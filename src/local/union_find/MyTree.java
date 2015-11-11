package local.union_find;

class MyTree extends Node
{
	private int height;
	
	/**
	 * Construtor da classe.
	 * Inicializa os campos com valores padrões: 0 para os tipos inteiros
	 * e Null para os tipos compostos.
	 * @param value é o valor inicial desejado para o primeiro nó da árvore.
	 */
	MyTree( int value )
	{
		super( value );
		this.height = 1;
	}
	
	/**
	 * Informa a altura desta árvore.
	 * @return um inteiro correspondente à altura desta árvore (valor mínimo = 1).
	 */
	int getHeight() { return this.height; }
	
	/**
	 * Adiciona uma nova sub-árvore na árvore.
	 * @param root é a raiz, o ponteiro para instância onde será adicionada
	 * a nova sub-árvore.
	 * @param subTree é o ponteiro para a nova sub-árvore. 
	 * @param localHeight é uma variável para auxiliar na definição da altura
	 * da árvore.
	 * @return um casting para o tipo Node da sub-árvore inserida ou uma
	 * nova chamada deste método (recursão).
	 */
	private Node addTree( Node root, MyTree subTree, int localHeight )
	{
		if( root == null )
		{	
			localHeight += subTree.height;
			
			if( localHeight > this.height )
				this.height = localHeight;
		}
		
		localHeight++;
		
		if( root.getValue() > subTree.getValue() )
			root.setLeft( this.addTree( root.getLeft(), subTree, localHeight ) );
		
		else if( root.getValue() < subTree.getValue() )
			root.setRight( this.addTree( root.getRight(), subTree, localHeight ) );
		
		else
		{
			root.setLeft( this.addTree( root.getLeft(), ( MyTree )subTree.getLeft(), localHeight ) );
			root.setRight( this.addTree( root.getRight(), ( MyTree )subTree.getRight(), localHeight ) );
		}
		
		return ( Node )subTree;
	}
	
	/**
	 * Interface para adicionar uma nova sub-árvore na instância da árvore.
	 * @param newSubTree é o ponteiro para a nova sub-árvore.
	 */
	void addNode( MyTree newSubTree ) { this.addTree( this, newSubTree, 0 ); }
	
	/**
	 * Faz uma busca binária na árvore, retornando o númeor do nível onde a
	 * chave informada foi encontrado ou startHeight caso a chave não seja
	 * encontrada.
	 * @param root é o endereço do nó por onde a busca deve começar.
	 * @param key é o valor a ser encontrado na árvore.
	 * @param startHeight é uma variável auxiliar que será incrementada 
	 * conforme a busca se aprofunde.
	 * @return o número do nível onde o nó foi encontrado, ou a altura da
	 * sub-árvore onde a busca foi feita (direita ou esquerda) acrescentado
	 * de uma unidade, quando o nó não for encontrado.
	 */
	private int binarySearch( Node root, int key, int startHeight )
	{	
		if( root == null )
			return startHeight;
		
		startHeight++;
		
		if( root.getValue() > key )
			return this.binarySearch( root.getLeft(), key, startHeight );
		
		else if( root.getValue() < key )
			return this.binarySearch( root.getRight(), key, startHeight );
		
		return startHeight;
	}
	
	/**
	 * Interface para buscar um determinado valor na árvore.
	 * @param key é uma chave correspondente ao valor armazenado no nó que
	 * se deseja encontrar. 
	 * @return o número do nível onde o nó foi encontrado, ou a altura da
	 * sub-árvore onde a busca foi feita (direita ou esquerda) acrescentado
	 * de uma unidade, quando o nó não for encontrado.
	 */
	int binarySearch( int key ) { return this.binarySearch( this, key, 0 ); }
}
