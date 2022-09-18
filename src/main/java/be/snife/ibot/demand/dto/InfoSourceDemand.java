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
public class InfoSourceDemand {

	private InfoSource  infoSource;

	private List<RealEstate> realEstateList;

}
