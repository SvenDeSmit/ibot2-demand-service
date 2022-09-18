package be.snife.ibot.demand.dto;

import java.io.Serializable;
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
public class WorkflowDemand {
	
	private String demandId;
	private String dossierId;
	
	private List<RealEstateDemand> realEstateDemandList;

	private List<InfoSourceDemand> infoSourceDemandList;
	

}
