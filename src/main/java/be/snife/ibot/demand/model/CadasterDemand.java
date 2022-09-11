package be.snife.ibot.demand.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CadasterDemand extends ElementaryDemand {

	private String cadasterDemandHeader1;
	private String cadasterDemandHeader2;
	
	private String cadasterDemandField1;
	private String cadasterDemandField2;
	private String cadasterDemandField3;

	public CadasterDemand() {
		demandSubType = "cadaster-demand";
	}

	
}
