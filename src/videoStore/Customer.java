
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

	
	public String getName() {
		return name;
	}

	
	public String englishStatement() {

		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : rentals) {
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + each.amountFor() + "$\n";
		}
		// add footer lines
		result += "Amount owed is " + getTotalAmount() + "$\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points\n";
		return result;
	}
	
	public String frenchStatement() {

		String result = "Facture de location pour " + getName() + "\n";

		for (Rental each : rentals) {
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + each.amountFor() + "$\n";
		}
		// add footer lines
		result += "Le montant dû est : " + getTotalAmount() + "$\n";
		result += "Vous avez obtenu " + getTotalFrequentRenterPoints() + " points de fidélité\n";
		return result;
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
