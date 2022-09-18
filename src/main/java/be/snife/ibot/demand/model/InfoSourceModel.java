package be.snife.ibot.demand.model;

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
public class InfoSourceModel {
	
	private String infoSourceId;
	private String infoSourceName;
	private String categoryId;

}
