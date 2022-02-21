package videoStore;

public class FrenchStatement extends Statement {
	
	public FrenchStatement(Customer c) {
        super(c);
    }
	
	@Override
	public String printHeader(Customer c) {
		return  "Facture de location pour " + customer.getName() + "\n";
	}
	
	@Override
	public String printRentalLine(Customer c) {
		
		String result = "";
		
		for (Rental each : customer.getRentals()) {
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + each.amountFor() + "$\n";
		}
		return result;
	}
	
	@Override
	public String printFooter(Customer c) {
		String result = "Le montant dû est : " + customer.getTotalAmount() + "$\n";
		result += "Vous avez obtenu " + customer.getTotalFrequentRenterPoints() + " points de fidélité\n";
		return result;
	}

}
