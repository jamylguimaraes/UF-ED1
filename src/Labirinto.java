import java.util.Scanner;

public class Labirinto {
	private int N; // Dimensao do labirinto
	private boolean[][] norte; // Matriz norte
	private boolean[][] leste; // Matriz leste
	private boolean[][] sul;   // Matriz sul
	private boolean[][] oeste; // Matriz oeste
	private boolean[][] visitado; // Matriz de Visitados
	private boolean completo = false;  // Variavel que indica o status
	static int inicio1;             // Valor no eixo X do ponto inicial
	static int inicio2;				// Valor no eixo Y do ponto inicial
	static int fim1;				// Valor no eixo X do ponto final
	static int fim2;				// Valor no eixo Y do ponto final

	/*
	 * Metodo Construtor
	 * Recebe como parametro o tamanho em int do Labirinto
	 * Desenha no eixo X (0, N+2)
	 * Desenha no eixo Y (0, N+2)
	 * Chama o metodo inicializar e o criar 
	 */
	public Labirinto(int N) {
		this.N = N;
		StdDraw.setXscale(0, N + 2);
		StdDraw.setYscale(0, N + 2);
		inicializar();
		criar();
	}

	/*
	 * Metodo Inicializar
	 */
	private void inicializar() {
		// inicializa as celulas do eixo Y e X como ja visitadas
		visitado = new boolean[N + 2][N + 2];
		for (int x = 0; x < N + 2; x++)
			visitado[x][0] = visitado[x][N + 1] = true;
		for (int y = 0; y < N + 2; y++)
			visitado[0][y] = visitado[N + 1][y] = true;

		// Realiza dois for no eixo X e Y ao norte, leste, sul e oeste e seta como true
		norte = new boolean[N + 2][N + 2];
		leste = new boolean[N + 2][N + 2];
		sul = new boolean[N + 2][N + 2];
		oeste = new boolean[N + 2][N + 2];
		for (int x = 0; x < N + 2; x++)
			for (int y = 0; y < N + 2; y++)
				norte[x][y] = leste[x][y] = sul[x][y] = oeste[x][y] = true;
	}

	/*
	 * Metodo criar recebe como parametros coordenadas do eixo x e y 
	 * Marca como visitados
	 */
	private void criar(int x, int y) {
		visitado[x][y] = true;
		double r;
		// enquanto houver um vizinho que nao foi visitado
		while (!visitado[x][y + 1] || !visitado[x + 1][y]
				|| !visitado[x][y - 1] || !visitado[x - 1][y]) {

			// pega o vizinho aleatoriamente
			while (true) {
				r = Math.random();
				if (r < 0.25 && !visitado[x][y + 1]) {
					norte[x][y] = sul[x][y + 1] = false;
					criar(x, y + 1);
					break;
				} else if (r >= 0.25 && r < 0.50 && !visitado[x + 1][y]) {
					leste[x][y] = oeste[x + 1][y] = false;
					criar(x + 1, y);
					break;
				} else if (r >= 0.5 && r < 0.75 && !visitado[x][y - 1]) {
					sul[x][y] = norte[x][y - 1] = false;
					criar(x, y - 1);
					break;
				} else if (r >= 0.75 && r < 1.00 && !visitado[x - 1][y]) {
					oeste[x][y] = leste[x - 1][y] = false;
					criar(x - 1, y);
					break;
				}
			}
		}
	}

	/*
	 * SobreCarga do Metodo criar, passa como parametros X = 1 e Y = 1 
	 */
	private void criar() {
		criar(1, 1);

	}

	// resolve o labirinto utilizando-se de recursao
	private void resolver(int x, int y) {
		if (x == 0 || y == 0 || x == N + 1 || y == N + 1)
			return;
		if (completo || visitado[x][y])
			return;
		visitado[x][y] = true;

		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
		StdDraw.show(30);

		// passando o parametro onde o labirinto ira terminar.
		if (x == fim2 && y == fim1)
			completo = true;
		// se aproveita da pilha de execucao do sistema , para realizar busca em
		// profundidade.
		if (!norte[x][y])
			resolver(x, y + 1);
		if (!leste[x][y])
			resolver(x + 1, y);
		if (!sul[x][y])
			resolver(x, y - 1);
		if (!oeste[x][y])
			resolver(x - 1, y);
		if (completo)
			return;

		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
		StdDraw.show(30);
	}

	/*
	 * Resolve o labirinto , comecando pelo parametro da posicao inicial passado
	 * no main
	 */

	public void resolver() {
		for (int x = 1; x <= N; x++)
			for (int y = 1; y <= N; y++)
				visitado[x][y] = false;
		completo = false;
		resolver(inicio2, inicio1);
	}

	// desenhando o labirinto
	public void desenhe() {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(fim2 + 0.5, fim1 + 0.5, 0.375);
		StdDraw.filledCircle(inicio2 + 0.5, inicio1 + 0.5, 0.375);

		StdDraw.setPenColor(StdDraw.BLACK);
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				if (sul[x][y])
					StdDraw.line(x, y, x + 1, y);
				if (norte[x][y])
					StdDraw.line(x, y + 1, x + 1, y + 1);
				if (oeste[x][y])
					StdDraw.line(x, y, x, y + 1);
				if (leste[x][y])
					StdDraw.line(x + 1, y, x + 1, y + 1);
			}
		}
		StdDraw.show(1000);
	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite a dimencao de sua Matriz");
		int N = sc.nextInt();

		System.out.println("Digite a posicao Onde Sua Matriz ira comecar");
		do {

			inicio1 = sc.nextInt();
			inicio2 = sc.nextInt();

			if (inicio1 > N || inicio2 > N || inicio1 < 1 || inicio2 < 1)
				System.out.println("Digite uma posicao contida na Matriz");

		} while (inicio1 > N || inicio2 > N || inicio1 < 1 || inicio2 < 1);

		System.out.println("Digite a posicao onde sua matriz ira terminar");
		do {

			fim1 = sc.nextInt();
			fim2 = sc.nextInt();

			if (fim1 > N || fim2 > N || fim1 < 1 || fim2 < 1)
				System.out.println("Digite uma posicao contida na Matriz");

		} while (fim1 > N || fim2 > N || fim1 < 1 || fim2 < 1);

		Labirinto Labirinto = new Labirinto(N);
		StdDraw.show(0);
		Labirinto.desenhe();
		Labirinto.resolver();
	}

}