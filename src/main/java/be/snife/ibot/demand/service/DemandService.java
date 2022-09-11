package be.snife.ibot.demand.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.snife.ibot.demand.model.Demand;
import be.snife.ibot.demand.repo.DemandRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DemandService {
	
	@Autowired
	private DemandRepository dr;

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
	

}
