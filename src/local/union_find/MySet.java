/**
 * Classe que representa um ou mais elementos agrupados
 * por alguma característica em comum, ou seja, um
 * conjunto.
 * Neste caso, os elementos do conjunto estão dispostos
 * na forma de uma árvore binária. 
 */
package local.union_find;

/**
 * @author Wesley Alves Torres 
 *
 */
public class MySet extends MyTree
{	
	/**
	 * Construtor da classe. Inicializa armazenando o valor
	 * informado e configurando os demais campos como nulo,
	 * ou 0 no caso de um campo numérico.
	 * @param value é o valor que será inicialmente
	 * armazenado neste Set.
	 */
	public MySet( int value ) { super( value ); }

	/** @return o identificador deste Set. */
	public int getId() { return this.getValue(); }
	
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
		if( setA.getHeight() > setB.getHeight() )
		{
			setA.addNode( setB );
			setB = setA;
		}			
		else
		{	
			setB.addNode( this );
			setA = setB;
		}
		
		return setA == setB;
	}
	
	/**
	 * Interface para fundir este conjunto a um outro conjunto.
	 * @param otherSet é um conjunto do tipo MySet.
	 * @return true se a união for executada, e false caso contrário.
	 */
	public boolean union( MySet otherSet ) { return this.union( this, otherSet ); }
}
