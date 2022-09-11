package be.snife.ibot.demand.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ListOfDemands extends CompositeDemand {

	private String listDemandHeader1;

	// implement constraints for list

	public ListOfDemands() {
		demandSubType = "simple-list-of-demands";
	}
			
}
