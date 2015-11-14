package local.tads;

public class SimpleLinkedList
{
	private SimpleSet element;
	private SimpleLinkedList next;
	
	public SimpleLinkedList( SimpleSet firstElement )
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
	public SimpleLinkedList getNext() { return this.next; }

	/**
	 * @param newValue the value to set
	 */
	public void setHead( double newValue ) { this.element.setValue( newValue ); }

	/**
	 * @param newElement the next to set
	 */
	public void addElement( SimpleLinkedList newElement ) 
	{ 
		SimpleLinkedList head = this;

		while( head.next != null )
			head = head.next;
		
		head.next = newElement;
	}
}
