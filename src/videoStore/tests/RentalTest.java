package videoStore.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import videoStore.Movie;
import videoStore.Rental;

public class RentalTest {
	
	public double EPLSILON = 0.001;
	
	Movie movies[];

	@Before
	public void setup() {
		movies = new Movie[3];

		movies[0] = new Movie("Caillou a le cancer", Movie.CHILDRENS);
		movies[1] = new Movie("31 Jump Street: Ninja Academy", Movie.NEW_RELEASE);
		movies[2] = new Movie("Les gars chauds se cachent pour vomir", Movie.REGULAR);
	}
	
	@Test
	public void testAmount() {
		
		Rental regulierMoinsDe2jours = new Rental(movies[2],2);
		Rental regulierPlusDe2jours = new Rental(movies[2],5);
		Rental children3joursOuMoins = new Rental(movies[0],3);
		Rental childrenPlusDe3jours = new Rental(movies[0],10);
		Rental NewRelease3parJour = new Rental(movies[1],3);
		
		
		// Regulier : 2 jours ou moins.
		assertEquals(regulierMoinsDe2jours.amountFor(),2,EPLSILON);
		// Regulier : plus de 2 jours.
		assertEquals(regulierPlusDe2jours.amountFor(),6.5,EPLSILON);
		// Childrens : 3 jours ou moins.
		assertEquals(children3joursOuMoins.amountFor(),1.5,EPLSILON);
		// Childrens : plus de 3 jours.
		assertEquals(childrenPlusDe3jours.amountFor(),12,EPLSILON);
		// New Release : une seule regle (3$ par jours).
		assertEquals(NewRelease3parJour.amountFor(),9,EPLSILON);
	}
	
	@Test
	public void testPoints() {
		
		// Film pour enfants :
		assertEquals(new Rental(movies[0],1).pointsFor(), 1);
		// Film reguliers :
		assertEquals(new Rental(movies[2],1).pointsFor(), 1);
		// Film New Release
		assertEquals(new Rental(movies[1],1).pointsFor(), 2);
	}


}
