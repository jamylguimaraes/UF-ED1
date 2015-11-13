import java.util.Scanner;

import local.tads.LinkedList;
import local.tads.SimpleSet;

public class Labrinto2
{

	public static void main( String[] args )
	{
		Scanner scan = new Scanner( System.in );

		LinkedList south, east, north;

		double r;
		
		System.out.println("Digite a dimensao de sua Matriz");
		int size = scan.nextInt();

		south = new LinkedList( new SimpleSet( 1 ) );
		east = new LinkedList( new SimpleSet( 1 ) );
		north = new LinkedList( new SimpleSet( 1 ) );
		
		LinkedList eHead = east;
		LinkedList sHead;
		LinkedList nHead;
		
		for( int i = 2; i < ( size + 1 ); i++ )
		{
			south.addElement( new LinkedList( new SimpleSet( i ) ) );
			east.addElement( new LinkedList( new SimpleSet( i ) ) );
			north.addElement( new LinkedList( new SimpleSet( i ) ) );
		}
		
		eHead = east;
		while( eHead != null )
		{
			do
			{
				r = ( Math.random() * 10 ) + 1;
			} while( r > ( size + 1 ) );
			
			sHead = south;
			while( !sHead.getElement().find( ( int )r ) )
				sHead = sHead.getNext();
			
			eHead.getElement().union( sHead.getElement() );
			
			do
			{
				r = ( Math.random() * 10 ) + 1;
			} while( r > ( size + 1 ) );
			
			nHead = north;
			while( !nHead.getElement().find( ( int )r ) )
				nHead = nHead.getNext();
			
			sHead.getElement().union( nHead.getElement() );
			
			eHead = eHead.getNext();
		}
		
		StdDraw.setXscale( 0, size );
		StdDraw.setYscale( 0, size );
		
		StdDraw.setPenColor( StdDraw.BLACK );
		
		StdDraw.line(1, 1, 1, size);
		StdDraw.line(1, size, size, size);
		StdDraw.line(size, size, size, 1);
		StdDraw.line(size, 1, 1, 1);
		
		eHead = east;
		while( eHead != null )
		{
			for( int y = 1; y < size; y++ )
			{
				double x = eHead.getElement().getValue();
				
				if( !eHead.getElement().find( y ) )
				{
					StdDraw.line( x, y, x, ( y + 1 ) );
					
					if( ( x + 1 ) <= size )
						StdDraw.line( x, y, x + 1, y );
				}
			}
			
			eHead = eHead.getNext();
		}

		StdDraw.show( 10000 );
		scan.close();
	}
}
