package be.snife.ibot.demand.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.snife.ibot.demand.dto.SubmitDemand;
import be.snife.ibot.demand.dto.SubmitDemandReply;
import be.snife.ibot.demand.model.Demand;
import be.snife.ibot.demand.service.DemandService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/demands")
@Slf4j
public class DemandController {
	
	@Autowired
	private final DemandService ds;
	
	public DemandController(DemandService ds) {
		this.ds = ds;
	}

	@GetMapping
	public List<Demand> getAllDemands() {
		log.info("Getting all Demands ...");
		Iterable<Demand> result = ds.getAllDemands();
		List<Demand> demands = 
				  StreamSupport.stream(result.spliterator(), false)
				    .collect(Collectors.toList());
		return demands;
	} 
	
	
/*	
	@PostMapping
	public ResponseEntity<?> createDemand(@RequestBody Demand demand) {
		log.info("Creating a Demand ...");
		String demandID = ds.createDemand(demand);
		log.info("Demand created with ID : "+demandID);
		
		ResponseEntity<?> result = ResponseEntity.status(HttpStatus.ACCEPTED).body(demandID);

		return result;
		
	}
*/
	
	@PostMapping()
	public ResponseEntity<SubmitDemandReply> submitDemand(@RequestBody SubmitDemand submitDemand) {
		log.info("Submitting a Demand ...");
		log.info(submitDemand.toString());
		SubmitDemandReply sd = ds.submitDemand(submitDemand);
		log.info("Demand submitted with process instance ID : "+sd.getProcessIstanceId());
		log.info(sd.toString());
		
		ResponseEntity<SubmitDemandReply> result = ResponseEntity.status(HttpStatus.ACCEPTED).body(sd);

		return result;
		
	}
	
}