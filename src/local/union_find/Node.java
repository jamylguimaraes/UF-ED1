/**
 * 
 */
package local.union_find;

/**
 * @author Wesley Alves Torres
 *
 */
class Node
{
	private int value;
	private Node left, right;

	/**
	 * Construtor da classe. Inicializa com left e right
	 * nulos, e com o value informado no parâmetro.
	 * @param value é o valor que se deseja armazenar
	 * neste nó.
	 */
	public Node( int value )
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
	protected Node getLeft() { return this.left; }

	/**
	 * Retorna um ponteiro para o nó à direita deste nó,
	 * ou nulo caso não exista um nó à direita.
	 * @return right é o ponteiro para o nó à direita.
	 */
	protected Node getRight() { return this.right; }

	/**
	 * Retorna o valor inteiro armazenado neste nó.
	 * @return value é o valor armazenado.
	 */
	protected int getValue() { return this.value; }

	/**
	 * "Posiciona" um nó informado à esquerda deste nó.
	 * @param left é o nó que se deseja encadear.
	 */
	protected void setLeft( Node newLeft ) { this.left = newLeft; }
	
	/**
	 * "Posiciona" um nó informado à direita deste nó.
	 * @param right é o nó que se deseja encadear.
	 */
	protected void setRight( Node newRight ) { this.right = newRight; }
	
	/**
	 * Armazena um valor informado dentro deste nó.
	 * @param value é o valor que se deseja armazenar.
	 */
	protected void setValue( int newValue ) { this.value = newValue; }
}
