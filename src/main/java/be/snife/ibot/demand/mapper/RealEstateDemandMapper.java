package be.snife.ibot.demand.mapper;

import java.util.ArrayList;

import be.snife.ibot.demand.dto.RealEstateDemand;
import be.snife.ibot.demand.dto.SubmitDemand;
import be.snife.ibot.demand.model.Demand;
import be.snife.ibot.demand.model.InfoSourceModel;
import be.snife.ibot.demand.model.ListOfDemands;
import be.snife.ibot.demand.model.RealEstateDemandModel;
import be.snife.ibot.demand.model.RealEstateModel;

public class RealEstateDemandMapper {

	
	public static Demand map(SubmitDemand sd) {
		
		ListOfDemands demand = new ListOfDemands();
		demand.setDossierId(sd.getDossierId());
		demand.setClientDemandReference(sd.getClientDemandReference());
		
		sd.getRealEstateDemandList().forEach((red) -> {
			RealEstateDemandModel redm = new RealEstateDemandModel();
			RealEstateModel rem = new RealEstateModel(red.getRealEstate().getRealEstateId());
			redm.setRealEstate(rem);
			redm.setInfoSourceList(new ArrayList<InfoSourceModel>());
			
			red.getInfoSourceList().forEach((ins) -> {
				InfoSourceModel ism = new InfoSourceModel(ins.getInfoSourceId(), ins.getInfoSourceName(), ins.getCategoryId());
				redm.getInfoSourceList().add(ism);				
			});
			demand.getComposedOf().add(redm);
		});
		
				
		// later
		// sd.getInfoSourceDemandList();

		return demand;
	}
}
