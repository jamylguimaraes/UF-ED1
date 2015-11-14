import java.util.Scanner;

import local.tads.SimpleLinkedList;
import local.tads.SimpleSet;

public class Labrinto2
{

	public static void main( String[] args )
	{
		Scanner scan = new Scanner( System.in );

		SimpleLinkedList south, yList;

		double r;
		
		System.out.println("Digite a dimensao de sua Matriz");
		int size = scan.nextInt();

		south = new SimpleLinkedList( new SimpleSet( 1 ) );
		yList = new SimpleLinkedList( new SimpleSet( 1 ) );
		
		SimpleLinkedList xSet = yList;
		SimpleLinkedList sHead;
		
		for( int i = 2; i < ( size + 1 ); i++ )
		{
			south.addElement( new SimpleLinkedList( new SimpleSet( i ) ) );
			yList.addElement( new SimpleLinkedList( new SimpleSet( i ) ) );
		}
		
		xSet = yList;
		while( xSet != null )
		{
			do
			{
				r = ( Math.random() * 10 ) + 1;
			} while( r > ( size + 1 ) );
			
			sHead = south;
			while( !sHead.getElement().find( ( int )r ) )
				sHead = sHead.getNext();
			
			xSet.getElement().union( sHead.getElement() );
			
			xSet = xSet.getNext();
		}
		
		StdDraw.setXscale( 0, size );
		StdDraw.setYscale( 0, size );
		
		StdDraw.setPenColor( StdDraw.BLACK );
		
		StdDraw.line(1, 1, 1, size);
		StdDraw.line(1, size, size, size);
		StdDraw.line(size, size, size, 1);
		StdDraw.line(size, 1, 1, 1);
		
		xSet = yList;
		while( xSet != null )
		{
			for( int y = 1; y < size; y++ )
			{
				double x = xSet.getElement().getValue();
				
				if( !xSet.getElement().find( y ) )
				{
					StdDraw.line( x, y, x, ( y + 1 ) );
					
					if( ( x + 1 ) <= size )
						StdDraw.line( x, y, x + 1, y );
				}
			}
			
			xSet = xSet.getNext();
		}

		StdDraw.show( 10000 );
		scan.close();
	} 
}
