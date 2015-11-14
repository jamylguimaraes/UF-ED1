import local.tads.SimpleLinkedList;
import local.tads.SimpleSet;

public class Labirinto2
{
	private SimpleLinkedList beginPoints, endPoints;
	
	public Labirinto2( int size )
	{
		beginPoints = populateList( size );
		endPoints = populateList( size );
	}
	
	private SimpleLinkedList populateList( int size )
	{
		SimpleLinkedList localList  = new SimpleLinkedList( new SimpleSet( 1 ) );
		double random;
		
		for( int i = 2; i < ( size + 1 ); i++ )
		{
			SimpleSet x = new SimpleSet( i );
			
			do
			{
				random = ( int )( Math.random() * 100 ) + 1;
			} while( random > size );
			
			SimpleSet y = new SimpleSet( random );
			y.union( x );
			
			localList.addElement( new SimpleLinkedList( y ) );
		}
		
		return localList;
	}
	
	private void drawMaze( SimpleLinkedList setOfBegins, SimpleLinkedList setOfEnds, int size )
	{
		
		StdDraw.setXscale( 0, size );
		StdDraw.setYscale( 0, size );
		
		StdDraw.setPenColor( StdDraw.BLACK );
		
		StdDraw.line(1, 1, 1, size);
		StdDraw.line(1, size, size, size);
		StdDraw.line(size, size, size, 1);
		StdDraw.line(size, 1, 1, 1);
		
		while( setOfBegins != null )
		{
			double x1 = setOfBegins.getElement().getId().getValue();
			double y1 = setOfBegins.getElement().getValue();
			
			SimpleLinkedList yPoint = setOfEnds;
			while( !yPoint.getElement().find( x1 ) )
			{
				double y2 = yPoint.getElement().getId().getValue();
				double x2 = yPoint.getElement().getValue();
				
				if( x2 != size )
					StdDraw.line( x2, y2, ( x2 + 1 ), y2  );
				else
					StdDraw.line( x2, y2, ( x2 - 1 ), y2  );
				
				yPoint = yPoint.getNext();
			}
			
			for( int i = 1; i < size; i++ )
			{
				if( i == size )
					StdDraw.line( x1, i, x1, ( i - 1 )  );
				
				if( i != yPoint.getElement().getValue() )
					StdDraw.line( x1, i, x1, ( i + 1 )  );
			}
			
			if( y1 < size )
				StdDraw.line( y1, x1, ( y1 + 1 ), x1  );
			
			setOfBegins = setOfBegins.getNext();
		}

		StdDraw.show( 10000 );
	}
	
	public void drawMaze( int size ){ this.drawMaze( this.beginPoints, this.endPoints, size ); }
}