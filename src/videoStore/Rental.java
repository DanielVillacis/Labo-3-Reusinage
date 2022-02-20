
package videoStore;

import java.util.Date;

/**
 * M. Fowler, et al., Refactoring, Improving the design of existing code,
 * Addison-Wiley, 2000. Exemple Chapitre 1
 * 
 * The class Rental is just a simple data class
 */

public class Rental {
	private int daysRented_;
	private Movie movie_;
	private Date date_;

	
	public Rental(Movie movie, Date initialDate, int daysRented) {
		movie_ = movie;
		daysRented_ = daysRented;
		//Initialise avec la date du jour
		date_ = initialDate;
	}
	
	public Rental(Movie movie, int daysRented) {
		this(movie,new Date(),daysRented);
	}

	public int getDaysRented() {
		return daysRented_;
	}

	public Movie getMovie() {
		return movie_;
	}
	
	public Date getDate() {
		return date_;
	}

	public int pointsFor() {
		// add bonus for a new release rental
		if (getMovie().getPriceCode() == Movie.NEW_RELEASE)
			return 2;
		return 1;
	}
	
	public double amountFor() {
		
		
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			if (getDaysRented() > 2) {
				return 2 + (getDaysRented() - 2) * 1.5;
			}
			else {
				return 2;
			}
		case Movie.NEW_RELEASE:
			return getDaysRented() * 3;
		case Movie.CHILDRENS:
			if (getDaysRented() > 3) {
				return 1.5 + (getDaysRented() - 3) * 1.5;
			}
			else {
				return 1.5;
			}
		default: 
			return 0;
		}
		
	}
}
