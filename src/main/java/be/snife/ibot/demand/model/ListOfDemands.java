package be.snife.ibot.demand.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
//@AllArgsConstructor
@Slf4j
public class ListOfDemands extends CompositeDemand {

	//private String listDemandHeader1;

	// implement constraints for list

	public ListOfDemands() {
		demandSubType = "simple-list-of-demands";
	}
	
	public String toString() {
		ObjectMapper om = new ObjectMapper();
		String res = null;
		try {
			res = om.writeValueAsString(this);
		} catch(JsonProcessingException e) {
			log.error("Cannot create JSON from RealEstate object",e);
		}
		return res;
	}
			
}
