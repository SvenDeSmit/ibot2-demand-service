package be.snife.ibot.demand.model;

import java.util.Date;

// READ: https://www.baeldung.com/jackson-inheritance

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "demandSubType")
@JsonSubTypes({ 
	    @Type(value = ListOfDemands.class, name = "simple-list-of-demands"),
		@Type(value = VIPDemand.class, name = "vip-demand"),
		@Type(value = AUSADemand.class, name = "ausa-demand"),
		@Type(value = CadasterDemand.class, name = "cadaster-demand") })
public abstract class Demand {

	@Id
	private String ID = UUID.randomUUID().toString();
	private Date createdAt = new Date(); 
	private String dossierId; 
	private String clientDemandReference ; 

	protected String demandType;
	@JsonIgnore
	protected String demandSubType;
/*
	protected DemandHeader header;
	
	@Data
	@AllArgsConstructor
	public class DemandHeader {
		private String createdAt;
		private String dossierID;
		private String clientReference;
		
		public DemandHeader() {
			
		}
	}
*/	
}
