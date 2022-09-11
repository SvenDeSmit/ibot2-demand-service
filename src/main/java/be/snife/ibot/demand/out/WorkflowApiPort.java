package be.snife.ibot.demand.out;

import be.snife.ibot.demand.model.Demand;

public interface WorkflowApiPort {
	public String sendDemand(Demand demand);
}
