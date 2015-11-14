package local.tads;

class DoubleLinkedList extends DoubleLinkedNode
{
	private int leftSize, rightSize;
	
	protected DoubleLinkedList( Object value ) 
	{
		super( value );
		this.leftSize = 0;
		this.rightSize = 0;
	}
	
	protected int getSize(){ return this.leftSize + this.rightSize + 1; }
	
	protected void addElement( Object newElement )
	{
		if( this.leftSize > this.rightSize )
		{
			while( this.rightSize > 0 )
				this.goRight();
		
		this.setRight( new DoubleLinkedNode( newElement ) );
		this.getRight().setLeft( this );
		this.rightSize++;
		}
		
		while( this.leftSize > 0 )
			this.goLeft();
		
		this.setLeft( new DoubleLinkedList( newElement ) );
		this.getLeft().setRight( this );
		this.leftSize++;
	}
	
	private void goLeft( DoubleLinkedList from )
	{
		if( from.getLeft() != null )
		{
			from = ( DoubleLinkedList )from.getLeft();
			from.leftSize--;
			from.rightSize++;
		}
	}
	
	protected void goLeft() { this.goLeft( this ); }
	
	private void goRight( DoubleLinkedList from )
	{
		if( from.getRight() != null )
		{
			from = ( DoubleLinkedList )from.getRight();
			from.leftSize++;
			from.rightSize--;
		}
	}
	
	protected void goRight() { this.goRight( this ); }
	
	protected void removeElement( Object reference )
	{
		boolean lNull = this.getLeft() == null;
		boolean rNull = this.getRight() == null;
		
		if( this.getValue().equals( reference ) )
		{
			if( lNull && rNull )
			{
				this.setValue( null );
				this.leftSize = 0;
				this.rightSize = 0;
			}
			else
			{
				if( lNull )
				{
					this.setValue( this.getRight().getValue() );
					this.setRight( this.getRight().getRight() );
					this.rightSize--;
				}
				else
				{
					this.setValue( this.getLeft().getValue() );
					this.setLeft( this.getLeft().getLeft() );
					this.leftSize--;
				}
			}
		}
		else
		{
			DoubleLinkedList l = ( DoubleLinkedList )this.getLeft();
			DoubleLinkedList r = ( DoubleLinkedList )this.getRight();
			
			
		}
	}
}
