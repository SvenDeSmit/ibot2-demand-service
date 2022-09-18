package be.snife.ibot.demand.out;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import be.snife.ibot.demand.out.dto.WorkflowDemand;
import be.snife.ibot.demand.out.dto.WorkflowDemandReply;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WorkflowApiAdapter implements WorkflowApiPort {

	private final RestTemplate rest;
	
	public WorkflowApiAdapter(RestTemplateBuilder restTemplateBuilder) {
		rest = restTemplateBuilder.build();	}

	@Override
	public WorkflowDemandReply sendDemand(WorkflowDemand wfDemand) {
		// Get out of config file!
		String url = "http://localhost:8090/api/demands";
		log.info("Submitting demand to workflow engine with demand id "+wfDemand.getDemandId());
		log.info(wfDemand.toString());
		WorkflowDemandReply reply = rest.postForObject(url, wfDemand, WorkflowDemandReply.class);
		log.info("Demand submitted to workflow engine with process instance id "+reply.getProcessIstanceId());
		return reply;
	}

}
