package jogoescadaseserpentes;

public class Counter {
	
	private String name;
	private Space currentSpace;
	
	
	public Counter(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Space getCurrentSpace() {
		return currentSpace;
	}

	/*
	 * Método que move o jogador e armazena onde ele está
	 */
	public void goTo(Space space) {
		currentSpace = space;	
	}
	public void play(Board board) {
		Dice dice = Dice.get();
		int diceNumber = dice.roll();
		
		System.out.format("Joagador '%s' jogou o dado e o resultado foi %d\n", name, diceNumber);
		
		board.move(this, diceNumber);
	}
	

}
