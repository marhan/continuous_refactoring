package refactoring.longmethod.composemethod;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import refactoring.longmethod.composemethod.ListImpl;

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
	
	@Test
	public void whenAddTwentyItemsThanAllAreFound() {
		
		List<Object> elements = createElements(20); 
		
		for (Object element : elements) {
			subject.add(element);
		}
		
		for (Object element : elements) {
			assertThat(subject.getElements(), hasItemInArray(element));
		}
		
	}

	private List<Object> createElements(int quantity) {
		List<Object> arrayList = new ArrayList<Object>();
		
		for(int i = 1 ; i <= quantity; i++) {
			arrayList.add(new String("Test Element "));
		}
		
		return arrayList;
	}
	

}
