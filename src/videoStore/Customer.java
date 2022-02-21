
package videoStore;

import java.util.Vector;


/**
 * M. Fowler, et al., Refactoring, Improving the design of existing code,
 * Addison-Wiley, 2000. Exemple Chapitre 1
 * 
 * The Customer class represents the customer of the store.
 * 
 */

public class Customer {
	private String name;
	private Vector<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new Vector<Rental>();
	}
	

	public void addRentals(Rental arg) {
		rentals.addElement(arg);
	}
	
	public Vector<Rental> getRentals() {
		return rentals;
	}

	
	public String getName() {
		return name;
	}

	public String englishStatement() {	
		EnglishStatement enSt = new EnglishStatement(this);
        return enSt.print(this);
	}
	
	public String frenchStatement() {
		FrenchStatement frSt= new FrenchStatement(this);
		return frSt.print(this);
	}
	
	public int getTotalFrequentRenterPoints() {

		int totalPoints = 0;

		for (Rental each : rentals) {
			totalPoints += each.pointsFor();
		}
		return totalPoints;
	}


	public double getTotalAmount() {
		double totalAmount = 0;
		
		for (Rental each : rentals) {
			totalAmount += each.amountFor();
		}
		return totalAmount;
	}

	
}
