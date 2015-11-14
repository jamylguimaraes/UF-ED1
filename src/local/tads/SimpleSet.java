package local.tads;

public class SimpleSet
{
	private SimpleSet id;
	private double value;
	
	public SimpleSet( double value )
	{
		this.id = this;
		this.value = value;
	}

	/**
	 * @return the id
	 */
	public SimpleSet getId() { return this.id; }
	
	/**
	 * @return the value
	 */
	public double getValue() { return this.value; }

	/**
	 * @param newValue the value to set
	 */
	public void setValue( double newValue ) { this.value = newValue; }
	
	public boolean find( double key )
	{
		if( this.value == key )
			return true;
		
		if( this.id == this )
			return false;
		
		return this.id.find( key );
	}
	
	public SimpleSet union( SimpleSet otherSet )
	{
		if( this.find( otherSet.value ) )
			return null;
		
		if( this.id != this )
			return this.id.union( otherSet );
		
		this.id = otherSet.id;
		
		return this.id;
	}
}
