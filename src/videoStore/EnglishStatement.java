package videoStore;

public class EnglishStatement extends Statement {
	
	public EnglishStatement(Customer c) {
        super(c);
    }
	
	@Override
	public String printHeader(Customer c) {
		return  "Rental Record for " + customer.getName() + "\n";
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
		String result = "Amount owed is " + customer.getTotalAmount() + "$\n";
		result += "You earned " + customer.getTotalFrequentRenterPoints() + " frequent renter points\n";
		return result;
	}
	

}
