/**
 * 
 */
package local.tads;

/**
 * @author Wesley Alves Torres
 *
 */
class DoubleLinkedNode implements Comparable<Object>
{
	private Object value;
	private DoubleLinkedNode left, right;

	/**
	 * Construtor da classe. Inicializa com left e right
	 * nulos, e com o value informado no parâmetro.
	 * @param value é o valor que se deseja armazenar
	 * neste nó.
	 */
	protected DoubleLinkedNode( Object value )
	{
		this.value = value;
		this.left = null;
		this.right = null;
	}

	/**
	 * Retorna um ponteir para o nó à esquerda deste nó,
	 * ou nulo caso não exista um nó à esquerda.
	 * @return left é o ponteiro para o nó à esquerda.
	 */
	protected DoubleLinkedNode getLeft() { return this.left; }

	/**
	 * Retorna um ponteiro para o nó à direita deste nó,
	 * ou nulo caso não exista um nó à direita.
	 * @return right é o ponteiro para o nó à direita.
	 */
	protected DoubleLinkedNode getRight() { return this.right; }

	/**
	 * Retorna o valor inteiro armazenado neste nó.
	 * @return value é o valor armazenado.
	 */
	protected Object getValue() { return this.value; }

	/**
	 * "Posiciona" um nó informado à esquerda deste nó.
	 * @param left é o nó que se deseja encadear.
	 */
	protected void setLeft( DoubleLinkedNode newLeft ) { this.left = newLeft; }
	
	/**
	 * "Posiciona" um nó informado à direita deste nó.
	 * @param right é o nó que se deseja encadear.
	 */
	protected void setRight( DoubleLinkedNode newRight ) 
	{
		this.right = newRight; 
	}
	
	/**
	 * Armazena um valor informado dentro deste nó.
	 * @param value é o valor que se deseja armazenar.
	 */
	protected void setValue( Object newValue ) { this.value = newValue; }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ( ( left == null ) ? 0 : left.hashCode() );
		result = prime * result + ( ( right == null ) ? 0 : right.hashCode() );
		result = prime * result + ( ( value == null ) ? 0 : value.hashCode() );
		
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object otherObj )
	{
		if ( this == otherObj )
			return true;

		if ( otherObj == null )
			return false;
		
		if (!( otherObj instanceof DoubleLinkedNode ) )
			return false;
		
		DoubleLinkedNode other = ( DoubleLinkedNode )otherObj;
		
		if ( !this.value.equals( other.value ) )
			return false;
		
		else if ( this.left == null )
			if ( other.left != null )
				return false;
			
		else if ( !this.left.equals( other.left ) )
			return false;
		
		if ( this.right == null )
			if ( other.right != null )
				return false;
			
		else if ( !this.right.equals( other.right ) )
			return false;
		
		if ( this.value == null )
			if ( other.value != null )
				return false;
		
		return true;
	}

	@Override
	public int compareTo( Object obj )
	{
		if( obj instanceof DoubleLinkedNode  )
		{
			DoubleLinkedNode ln = ( DoubleLinkedNode )obj;
			return this.value.toString().compareTo( ln.value.toString() );
		}
			
		return this.value.toString().compareTo( obj.toString() );
	}
}
