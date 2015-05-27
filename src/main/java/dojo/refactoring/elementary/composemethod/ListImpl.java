package dojo.refactoring.elementary.composemethod;

/*
 * Chapter 7.1 in the book
 */
public class ListImpl {

	private boolean readOnly;
	private int size;
	private Object[] elements = new Object[0];

	public void add(Object element) {
		
		if (!readOnly) {
			int newSize = size + 1;
			if (newSize > elements.length) {
				Object[] newElements = new Object[elements.length + 10];
				for (int i = 0; i < size; i++) {
					newElements[i] = elements[i];
				}
				elements = newElements;
			}
			elements[size++] = element;
		}
	}
	
	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public Object[] getElements() {
		return elements;
	}

}
