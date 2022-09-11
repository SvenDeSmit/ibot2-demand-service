package be.snife.ibot.demand.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import be.snife.ibot.demand.model.AUSADemand;
import be.snife.ibot.demand.model.CadasterDemand;
import be.snife.ibot.demand.model.CompositeDemand;
import be.snife.ibot.demand.model.Demand;
import be.snife.ibot.demand.model.ElementaryDemand;
import be.snife.ibot.demand.model.ListOfDemands;
import be.snife.ibot.demand.model.VIPDemand;

//@RunWith(SpringRunner.class)
@SpringBootTest
class DemandServiceTest {
	
	@Autowired
	DemandService ds;
	
	private static Demand demand1 = makeDemand1();
	
	private static Demand makeDemand1() {
		CompositeDemand list = new ListOfDemands("myListDemandHeader1");
		list.setCompositeDemandHeader1("myCompositeDemandHeader1");
		list.setCompositeDemandHeader2("myCompositeDemandHeader2");
		list.setCompositeDemandHeader3("myCompositeDemandHeader3");
		ElementaryDemand d1 = new VIPDemand("myVipDemandHeader1","myVipDemandHeader2","myVipDemandField1","myVipDemandField2","myVipDemandField3");
		d1.setElementaryDemandHeader1("myElementaryDemandHeader1");
		d1.setElementaryDemandHeader2("myElementaryDemandHeader2");
		d1.setElementaryDemandHeader3("myElementaryDemandHeader3");
		list.addDemand(d1);
		ElementaryDemand d2 = new AUSADemand("myAusaDemandHeader1","myAusaDemandHeader2","myAusaDemandField1","myAusaDemandField2","myAusaDemandField3");
		d2.setElementaryDemandHeader1("myElementaryDemandHeader1");
		d2.setElementaryDemandHeader2("myElementaryDemandHeader2");
		d2.setElementaryDemandHeader3("myElementaryDemandHeader3");
		list.addDemand(d2);
		ElementaryDemand d3 = new CadasterDemand("myCadasterDemandHeader1","myCadasterDemandHeader2","myCadasterDemandField1","myCadasterDemandField2","myCadasterDemandField3");
		d3.setElementaryDemandHeader1("myElementaryDemandHeader1");
		d3.setElementaryDemandHeader2("myElementaryDemandHeader2");
		d3.setElementaryDemandHeader3("myElementaryDemandHeader3");
		list.addDemand(d3);
		return list;
	}

	@Test
	void createDemandtest() {
		
		String demandID = ds.createDemand(demand1);
		
	}

	
	
	@Test
	void getDemandByIdtest() {
		String demandID = ds.createDemand(demand1);
		Optional<Demand> result = ds.getByIdDemand(demand1.getID());
		Demand demand = result.get();
		
	}
	

}
