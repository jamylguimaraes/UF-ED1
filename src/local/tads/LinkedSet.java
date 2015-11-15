package local.tads;

public class LinkedSet extends NodeSet
{
	public LinkedSet() { super( 0 ); }
	
	private void addValue( int newValue )
	{
		LinkedSet newSet = this;
		while( newSet.getNext() != null )
			newSet = ( LinkedSet )newSet.getNext();
		
		newSet.setNext( new NodeSet( newValue ) );
		newSet.getNext().setId( this.getId() );
	}
	
	public LinkedSet makeSet( int value )
	{ 
		this.setValue( value );
		return this;
	}
	
	private boolean find( LinkedSet source, int key )
	{
		if( source.getId().equals( source ) )
		{
			NodeSet element = source;
			
			do
			{
				if( element.getValue() == key )
					return true;
				
				element = element.getNext();
			} while( element != null );
			
			return false;
		}
		
		return source.find( ( LinkedSet )source.getId(), key );
	}
	
	public boolean find( int key ) { return this.find( this, key ); }
	
	public void union( LinkedSet representative )
	{
		NodeSet element = this;
		
		do												// Alterando os representantes dos
		{												// elementos do conjunto para o
			element.setId( representative.getId() );	// representante do outro conjunto.
			
			if( !representative.find( element.getValue() ) )	// Cada elemento deste set que não for encontrado
				representative.addValue( element.getValue() );	// em representative será adicionado nele.
			
			element = element.getNext();
		} while( element != null );						 
	}
}
