package be.snife.ibot.demand.dto;

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
public class SubmitDemandReply {

	private String dossierId;
	private String demandId;
	private String clientDemandReference ; 	
	private String processIstanceId;

}
