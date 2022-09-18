package be.snife.ibot.demand;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.snife.ibot.demand.model.AUSADemand;
import be.snife.ibot.demand.model.CadasterDemand;
import be.snife.ibot.demand.model.CompositeDemand;
import be.snife.ibot.demand.model.Demand;
import be.snife.ibot.demand.model.ElementaryDemand;
import be.snife.ibot.demand.model.ListOfDemands;
import be.snife.ibot.demand.model.VIPDemand;
import be.snife.ibot.demand.service.DemandService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationInitializer implements InitializingBean {

	@Autowired
	private DemandService ds;

	private static Demand demand1 = makeDemand1();
	
	private static Demand makeDemand1() {
		CompositeDemand list = new ListOfDemands();
		//list.setHeader(list.new DemandHeader("90-06-1968", "123456", "my-client-456789"));
		list.setDossierId("123456");
		list.setClientDemandReference("my-client-456789");
		//list.setCompositeDemandHeader1("myCompositeDemandHeader1");
		//list.setCompositeDemandHeader2("myCompositeDemandHeader2");
		//list.setCompositeDemandHeader3("myCompositeDemandHeader3");
		ElementaryDemand d1 = new VIPDemand("myVipDemandHeader1","myVipDemandHeader2","myVipDemandField1","myVipDemandField2","myVipDemandField3");
		d1.setDossierId("123456");
		d1.setClientDemandReference("my-client-456789");
		list.addDemand(d1);
		ElementaryDemand d2 = new AUSADemand("myAusaDemandHeader1","myAusaDemandHeader2","myAusaDemandField1","myAusaDemandField2","myAusaDemandField3");
		d2.setDossierId("123456");
		d2.setClientDemandReference("my-client-456789");
		list.addDemand(d2);
		ElementaryDemand d3 = new CadasterDemand("myCadasterDemandHeader1","myCadasterDemandHeader2","myCadasterDemandField1","myCadasterDemandField2","myCadasterDemandField3");
		d3.setDossierId("123456");
		d3.setClientDemandReference("my-client-456789");
		list.addDemand(d3);
		return list;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("Initializig application ...");
		ds.createDemand(demand1);
		log.info("Initial demand added to application ...");
		
		// TODO Auto-generated method stub

	}

}
