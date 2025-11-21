package hu.webuni.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Component;

import hu.webuni.airport.config.AirportConfigProperties;

//Spring-es Bean-re gyártás, nem kell @Service, mert már egyszer le van gyártva az AppConfigban: "return new DefaultDiscountService();", ha bent hagynám a @Service-t, akkor a component-scan-ben is jelen lenne (@Service által) és az AppConfig is létrehozna egyet (@Bean által), ami nem jó!
//@Service
public class DefaultDiscountService implements DiscountService{

	@Autowired
	AirportConfigProperties config;
	
	@Override
	public int getDiscountPercent(int totalPrice) {
		return config.getDiscount().getDef().getPercent();
	}

}