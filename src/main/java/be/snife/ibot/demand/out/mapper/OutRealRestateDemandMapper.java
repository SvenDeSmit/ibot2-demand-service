package be.snife.ibot.demand.out.mapper;

import java.util.ArrayList;

import be.snife.ibot.demand.model.ElementaryDemand;
import be.snife.ibot.demand.model.ListOfDemands;
import be.snife.ibot.demand.model.RealEstateDemandModel;
import be.snife.ibot.demand.out.dto.InfoSource;
import be.snife.ibot.demand.out.dto.RealEstate;
import be.snife.ibot.demand.out.dto.RealEstateDemand;
import be.snife.ibot.demand.out.dto.WorkflowDemand;

public class OutRealRestateDemandMapper {
	
	public static WorkflowDemand map(ListOfDemands lods) {
		WorkflowDemand wfd = new WorkflowDemand();
		wfd.setDossierId(lods.getDossierId());
		wfd.setDemandId(lods.getID());
		wfd.setClientDemandReference(lods.getClientDemandReference());
		wfd.setRealEstateDemandList(new ArrayList<RealEstateDemand>());
		
		lods.getComposedOf().forEach((demand) -> {
			if (demand instanceof ElementaryDemand) {
				if (demand instanceof RealEstateDemandModel) {
					RealEstateDemandModel d  = (RealEstateDemandModel)demand;
					RealEstateDemand red = new RealEstateDemand();
					red.setRealEstate(new RealEstate(d.getRealEstate().getRealEstateId()));
					red.setInfoSourceList(new ArrayList<InfoSource>()); 
					d.getInfoSourceList().forEach((isl) -> {
						InfoSource outIsl = new InfoSource(isl.getInfoSourceId(), isl.getInfoSourceName(), isl.getCategoryId());
						red.getInfoSourceList().add(outIsl);						
					});
					wfd.getRealEstateDemandList().add(red);
					
				} else {
					// add for PersonDemandModel
				}
			} else {
				// add for nested lists 
			}
		});
		
		return wfd;
	}

}
