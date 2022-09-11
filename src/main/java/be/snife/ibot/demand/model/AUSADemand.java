package be.snife.ibot.demand.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AUSADemand extends ElementaryDemand {

	private String ausaDemandHeader1;
	private String ausaDemandHeader2;
	
	private String ausaDemandField1;
	private String ausaDemandField2;
	private String ausaDemandField3;
	
	public AUSADemand() {
		demandSubType = "ausa-demand";
	}


}
