package dojo.refactoring.duplicatedcode.chainconstructors;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

public class LoanTest {
	
	private BigDecimal national = new BigDecimal("1.0");
	private BigDecimal outstanding = new BigDecimal("2.0");
	private int rating = 1;
	private Date expire = new Date();
	private Date maturity = new Date();

	@Test
	public void createNewTermROC() {
		
		Loan loan = new Loan(national, outstanding, rating, expire);
		
		assertThat(loan.getStrategy(), instanceOf(TermROC.class));
		
		assertThat(loan.getExpire(), equalTo(expire));
		assertThat(loan.getNational(), equalTo(national));
		assertThat(loan.getOutstanding(), equalTo(outstanding));
		assertThat(loan.getRating(), equalTo(rating));

		assertThat(loan.getMaturity(), nullValue());
	}
	
	@Test
	public void createNewRevolvingTermROC() {
		
		Loan loan = new Loan(national, outstanding, rating, expire, maturity );
		
		assertThat(loan.getStrategy(), instanceOf(RevolvingTermROC.class));
		
		assertThat(loan.getExpire(), equalTo(expire));
		assertThat(loan.getNational(), equalTo(national));
		assertThat(loan.getOutstanding(), equalTo(outstanding));
		assertThat(loan.getRating(), equalTo(rating));
		assertThat(loan.getMaturity(), equalTo(maturity));
	}
	
	@Test
	public void createGeneric() {
		
		CapitalStrategy strategy = new RevolvingTermROC();
		
		Loan loan = new Loan(strategy, national, outstanding, rating, expire, maturity );
		
		assertThat(loan.getStrategy(), equalTo(strategy));
		
		assertThat(loan.getExpire(), equalTo(expire));
		assertThat(loan.getNational(), equalTo(national));
		assertThat(loan.getOutstanding(), equalTo(outstanding));
		assertThat(loan.getRating(), equalTo(rating));
		assertThat(loan.getMaturity(), equalTo(maturity));
	}

}
