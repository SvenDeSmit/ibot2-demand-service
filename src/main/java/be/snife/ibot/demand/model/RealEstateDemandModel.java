package be.snife.ibot.demand.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RealEstateDemandModel extends ElementaryDemand {

	private RealEstateModel realEstate;

	private List<InfoSourceModel> infoSourceList;

	
	public RealEstateDemandModel() {
		demandSubType = "real-estate-demand";
	}

}
