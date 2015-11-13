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
	
	private SimpleSet find( SimpleSet source, double key )
	{
		if( source.value == key )
			return source;
		
		if( source.id != source )
			return source.find( source.id, key );
		
		return null;
	}
	
	public boolean find( double key ) { return this.find( this, key ) != null; }

	public SimpleSet union( SimpleSet otherSet )
	{
		if( this.id != this )
			return this.id.union( otherSet );
		
		this.id = otherSet;
		
		return this.id;
	}
}
