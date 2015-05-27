package dojo.refactoring.duplicatedcode.chainconstructors;

import java.math.BigDecimal;
import java.util.Date;

/*
 * Chapter 11.1 in the book
 * 
 * Smell: Duclicate Method
 * Refactoring: Chain Constructors
 * 
 */
public class Loan {

	private CapitalStrategy strategy;
	private BigDecimal national;
	private BigDecimal outstanding;
	private int rating;
	private Date expire;
	private Date maturity;

	public Loan(BigDecimal national, BigDecimal outstanding, int rating, Date expire, Date maturity) {
		this.strategy = new RevolvingTermROC();
		this.national = national;
		this.outstanding = outstanding;
		this.rating = rating;
		this.expire = expire;
		this.maturity = maturity;
	}

	public Loan(BigDecimal national, BigDecimal outstanding, int rating, Date expire) {
		this.strategy = new TermROC();
		this.national = national;
		this.outstanding = outstanding;
		this.rating = rating;
		this.expire = expire;
	}

	public Loan(CapitalStrategy strategy, BigDecimal national, BigDecimal outstanding, int rating, Date expire, Date maturity) {
		this.strategy = strategy;
		this.national = national;
		this.outstanding = outstanding;
		this.rating = rating;
		this.expire = expire;
		this.maturity = maturity;
	}

	public CapitalStrategy getStrategy() {
		return strategy;
	}

	public BigDecimal getNational() {
		return national;
	}

	public BigDecimal getOutstanding() {
		return outstanding;
	}

	public int getRating() {
		return rating;
	}

	public Date getExpire() {
		return expire;
	}

	public Date getMaturity() {
		return maturity;
	}
	
	

}
