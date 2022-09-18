package be.snife.ibot.demand.out;

import be.snife.ibot.demand.out.dto.WorkflowDemand;
import be.snife.ibot.demand.out.dto.WorkflowDemandReply;

public interface WorkflowApiPort {
	public WorkflowDemandReply sendDemand(WorkflowDemand demand);
}
