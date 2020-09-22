package jogoescadaseserpentes;
 

/*
 * Classe que gerencia os jogadores
 */
public class Counters implements Printable{
	
	private Counter[] counters;
	private int currentCounterIndex = -1;
	
	/*
	 * Gerenciador, cada jogador recebe como nome uma letra
	 */
	public Counters(Board board, int numPlayers) {
		counters = new Counter[numPlayers];
		char currentName = 'A';
		
		/*
		 * Incrementa os jogadores de acordo com a quatidade informada
		 */
		for (int i = 0; i <counters.length; i++) {
			counters[i] = new Counter(String.valueOf(currentName));
			currentName++;
			
		}
		/*
		 * Chama o método que posiciona os jogores no tabuleiro
		 */
		board.setupCouters(counters);
		
	}
	/* 
	 * Método para o próximo jogador do array
	 */
	public Counter next() {
		currentCounterIndex = (currentCounterIndex + 1) % counters.length;
		return counters[currentCounterIndex];
	}

	/*
	 * Método que sobrescreve informado as posições de cada jogador
	 */
	@Override
	public void print() {
		for(Counter counter : counters) {
			System.out.format("Jogador '%s' está na posição %s\n", counter.getName(), counter.getCurrentSpace());
		}
	}
}
