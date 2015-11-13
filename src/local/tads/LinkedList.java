package local.tads;

public class LinkedList
{
	private SimpleSet element;
	private LinkedList next;
	
	public LinkedList( SimpleSet firstElement )
	{
		this.element = firstElement;
		this.next = null;
	}

	/**
	 * @return the value
	 */
	public SimpleSet getElement() { return this.element; }

	/**
	 * @return the next
	 */
	public LinkedList getNext() { return this.next; }

	/**
	 * @param newValue the value to set
	 */
	public void setHead( double newValue ) { this.element.setValue( newValue ); }

	/**
	 * @param newElement the next to set
	 */
	public void addElement( LinkedList newElement ) 
	{ 
		LinkedList head = this;

		while( head.next != null )
			head = head.next;
		
		head.next = newElement;
	}
}
