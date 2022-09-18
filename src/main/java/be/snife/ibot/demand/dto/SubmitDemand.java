package be.snife.ibot.demand.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubmitDemand {
	
	private String dossierId;
	private String clientDemandReference ; 
		
	private List<RealEstateDemand> realEstateDemandList;

	private List<InfoSourceDemand> infoSourceDemandList;	

}
