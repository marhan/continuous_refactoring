package dojo.refactoring.elementary.composemethod;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListImplTest {

	private ListImpl subject;
	
	@Before
	public void setup() {
		subject = new ListImpl();
	}

	@Test
	public void whenAddOneItemThanItemIsFound() {
		
		Object element = new String("test");
		subject.add(element);
		
		assertThat(subject.getElements(), hasItemInArray(element));
	}
	
	@Test
	public void whenSetToReadOnlyAndAddOneItemThanNoItemIsFound() {
		
		subject.setReadOnly(true);

		Object element = new String("test");
		subject.add(element);
		
		assertThat(subject.getElements(), not(hasItemInArray(element)));
		
	}
	

}
