package be.snife.ibot.demand.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public abstract class ElementaryDemand extends Demand {
	
	private String elementaryDemandHeader1;
	private String elementaryDemandHeader2;
	private String elementaryDemandHeader3;
	
	public ElementaryDemand() {
		demandType = "elementary";
	}
	
}
