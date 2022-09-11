package be.snife.ibot.demand.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class VIPDemand extends ElementaryDemand {

	private String vipDemandHeader1;
	private String vipDemandHeader2;
	
	private String vipDemandField1;
	private String vipDemandField2;
	private String vipDemandField3;
	
	public VIPDemand() {
		demandSubType = "vip-demand";
	}
	

}
