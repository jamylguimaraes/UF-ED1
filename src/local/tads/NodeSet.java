package local.tads;

class NodeSet
{
	private int value;
	private NodeSet next, id;
	
	protected NodeSet( int value ) 
	{
		this.id = this;
		this.next = null;
		this.value = value;
	}

	/**
	 * @return the value
	 */
	protected int getValue() { return this.value; }

	/**
	 * @return the next
	 */
	protected NodeSet getNext() { return this.next; }

	/**
	 * @return the id
	 */
	protected NodeSet getId() { return this.id; }

	/**
	 * @param newValue the value to set
	 */
	protected void setValue( int newValue ) { this.value = newValue; }

	/**
	 * @param newNext the next to set
	 */
	protected void setNext( NodeSet newNext ) { this.next = newNext; }

	/**
	 * @param newID the id to set
	 */
	protected void setId( NodeSet newID ) { this.id = newID; }
}
