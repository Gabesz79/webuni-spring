package hu.webuni.airport.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

	private DiscountService discountService; //DiscountService interfacetől el kell kérni a kedvezmény mértékét (%)
	
	//ctor paraméterben injektálom a discountService-t
	public PriceService(DiscountService discountService) {
		//super(); //Nincs ősosztály, ezért nem kell!
		this.discountService = discountService;
	}

	public int getFinalPrice(int price) {
		return (int)(price / 100.0 * (100 - discountService.getDiscountPercent(price))); //A price paraméter alapján visszaadja a % kedvezményt, Maradékos osztás miatt fontos a .0
	}
}
