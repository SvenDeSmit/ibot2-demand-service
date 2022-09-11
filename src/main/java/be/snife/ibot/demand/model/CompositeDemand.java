package be.snife.ibot.demand.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CompositeDemand extends Demand {
	
	private String compositeDemandHeader1;
	private String compositeDemandHeader2;
	private String compositeDemandHeader3;
	

	public CompositeDemand() {
		demandType = "composite";
	}
	
	private List<Demand> composedOf = new ArrayList<Demand>();
	
	public void addDemand(Demand demand) {
		composedOf.add(demand);
	}

	public List<Demand> getComposedOf() {
		return composedOf;
	}
	
	
	
}
