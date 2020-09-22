package jogoescadaseserpentes;
 

/*
 * Classe que gerencia os jogadores
 */
public class Counters implements Printable{
	
	private Counter[] counters;
	private int currentCounterIndex;
	
	/*
	 * Gerenciador, cada jogador recebe como nome uma letra
	 */
	public Counters(Board board, int numPlayers) {
		counters = new Counter[numPlayers];
		char currentName = 'A';
		
		/*
		 * imcrementa os jogadores de acordo com a quatidade informada
		 */
		for (int i = 0; i <counters.length; i++) {
			counters[i] = new Counter(String.valueOf(currentName));
			currentName++;
			
		}
		/*
		 * Chama o m�todo que posiciona os jogores no tabuleiro
		 */
		board.setupCouters(counters);
		
	}

	/*
	 * Sobrescreve informado as posi��es de cada jogador
	 */
	@Override
	public void print() {
		for(Counter counter : counters) {
			System.out.format("Jogador '%s' est� na posi��o %s\n", counter.getName(), counter.getCurrentSpace());
		}
	}
}
