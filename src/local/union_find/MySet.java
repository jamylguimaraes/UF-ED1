/**
 * 
 */
package local.union_find;

/**
 * @author Wesley Alves Torres
 *
 */
public class MySet extends MyTree
{
	private Node id;
	
	/**
	 * Construtor da classe. Inicializa armazenando o valor
	 * informado e configurando os demais campos como nulo,
	 * ou 0 no caso de um campo numérico.
	 * @param value é o valor que será inicialmente
	 * armazenado neste Set.
	 */
	public MySet( int value )
	{
		super( value );
		
		this.id = this;
	}

	/** @return o identificador deste Set. */
	public Node getId() { return this.id; }
	
	/**
	 * Verifica se uma chave informada está contida neste Set.
	 * @param key é o valor inteiro cuja existência deve ser
	 * verificada.
	 * @return true se a chave iformada for encontrada e false
	 * caso contrário.
	 */
	public boolean find( int key )
	{
		return this.binarySearch( key ) < ( this.getHeight() + 1 );
	}
	
	/**
	 * Funde dois conjuntos em um único conjunto que contém todos
	 * os elementos dos conjuntos anteriores. 
	 * @param setA é um conjunto do tipo MySet.
	 * @param setB é outro conjunto do tipo MySet.
	 * @return true se a união for executada, false caso contrário.
	 */
	private boolean union( MySet setA, MySet setB )
	{
		boolean found = setA.find( setB.getId().getValue() );
		
		if( found )
		{
			if( setA.getHeight() > setB.getHeight() )
			{
				setA.addNode( setB );
				setA.id = setB.id;
				
				setB = null;
			}			
			else
			{	
				setB.addNode( this );
				
				setA = null;
			}
		}
		
		return found;
	}
	
	/**
	 * Interface para fundir este conjunto a um outro conjunto.
	 * @param otherSet é um conjunto do tipo MySet.
	 * @return true se a união for executada, e false caso contrário.
	 */
	public boolean union( MySet otherSet ) { return this.union( this, otherSet ); }
}
