package be.snife.ibot.demand.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.snife.ibot.demand.dto.SubmitDemand;
import be.snife.ibot.demand.dto.SubmitDemandReply;
import be.snife.ibot.demand.mapper.RealEstateDemandMapper;
import be.snife.ibot.demand.model.Demand;
import be.snife.ibot.demand.model.ListOfDemands;
import be.snife.ibot.demand.out.WorkflowApiPort;
import be.snife.ibot.demand.out.dto.RealEstateDemand;
import be.snife.ibot.demand.out.dto.WorkflowDemand;
import be.snife.ibot.demand.out.dto.WorkflowDemandReply;
import be.snife.ibot.demand.out.mapper.OutRealRestateDemandMapper;
import be.snife.ibot.demand.repo.DemandRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DemandService {
	
	@Autowired
	private DemandRepository dr;

	@Autowired
	private WorkflowApiPort waOutPort;
	
/*
	public DemandService(DemandRepository dr) {
		this.dr = dr;
	}
	
	public DemandService() {
		}
*/	
	
	public String createDemand(Demand demand) {
		log.debug("Saving demand with id = "+demand.getID());
		return dr.save(demand).getID();
	}
	
	public Optional<Demand> getByIdDemand(String demandID) {
		return dr.findById(demandID);
	}
	
	public Iterable<Demand> getAllDemands() {
		return dr.findAll();
	}
	
	// Must be replaced by an operation that get a demand id, gets it from the repo, translates it to a workflow demand, .... and stores the reply in MondoDB
	public SubmitDemandReply submitDemand(SubmitDemand inDemand) {
		log.info("Request to submit demand with client reference "+inDemand.getClientDemandReference()+" recieved");
		log.info(inDemand.toString());
				
		// input DTO model => model - Use mapping framework later!
		ListOfDemands demand = (ListOfDemands)RealEstateDemandMapper.map(inDemand);
		log.info("Storing demand with ID "+demand.getID());
		log.info(demand.toString());
			
		// STORE demand in DB
		dr.save(demand);
		log.info("Demand stored successfully");
				
		log.info("Submitting demand with ID "+demand.getID()+" to workflow ...");
		WorkflowDemand wfd = OutRealRestateDemandMapper.map(demand);
		log.info(wfd.toString());
		WorkflowDemandReply wfdr = waOutPort.sendDemand(wfd);
		SubmitDemandReply reply = new SubmitDemandReply(demand.getDossierId(),demand.getClientDemandReference(),demand.getID(),wfdr.getProcessIstanceId());
		log.info("Demand with ID "+demand.getID()+" successfully submitted to workflow");
		log.info(reply.toString());
				
		return reply;
	}

}
