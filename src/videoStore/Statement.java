package videoStore;

public abstract class Statement {
	
	Customer customer;
	double totalAmount;
	int TotalFrequentRenterPoints;
	
	
	public Statement(Customer c) {
		customer = c;
		totalAmount = customer.getTotalAmount();
		TotalFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
	}
	
	abstract String printHeader(Customer c);
	abstract String printRentalLine(Customer c);
	abstract String printFooter(Customer c);
	
	public String print(Customer c) {
		String result = this.printHeader(c);
		result += printRentalLine(c);
		result += printFooter(c);
		return result;
	}
	
}
