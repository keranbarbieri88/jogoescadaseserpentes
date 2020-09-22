package jogoescadaseserpentes;

import java.util.Arrays;

import jogoescadaseserpentes.Space.Type;

public class Board implements Printable{
	
	private Space[] spaces;
	private Space spaceHome;
	private Space spaceStartHere;
	
	/*
	 * Número de espaços mais 2
	 */
	public Board(int numSpaces) {
		spaces = new Space[numSpaces + 2];
		
		/*
		 * Condição para as casas do tabuleiro
		 */
		for(int i = 0; i< spaces.length; i++) {
			if (i == 0) {
				spaces[i] = new Space(0, Type.START_HERE);
				spaceStartHere = spaces[i];		
				
			} else if(i == spaces.length - 1) {
				spaces[i] = new Space(i, Type.HOME);
				spaceHome = spaces[i];
				
			} else {
				spaces[i] = new Space(i, Type.REGULAR);
			}
		}
	}

	@Override
	public String toString() {
		return "Board [spaces=" + Arrays.toString(spaces) + "]";
	}

	@Override
	public void print() {
		System.out.println("TABULEIRO:");
		for (Space space : spaces) {
			System.out.print(space + " ");
		}
		System.out.println();
	}

	/*
	 * Método que posiciona os jogores no tabuleiro chama o método
	 * que move o jogador
	 */
	public void setupCouters(Counter[] counters) {
		for (Counter counter : counters) {
			counter.goTo(spaceStartHere);
		}
		
	}

	public void move(Counter counter, int diceNumber) {
		Space space = counter.getCurrentSpace();
		 int newSpaceNumber = space.getNumber() + diceNumber;
		 
		 Space newSpace;
		 if (newSpaceNumber > spaceHome.getNumber()) {
			 newSpace = spaceHome;
		 } else {
			 newSpace = spaces[newSpaceNumber];
		 }
		 counter.goTo(newSpace);
		 System.out.format("Jogador '%s' foi para a casa %s\n", counter.getName(), newSpace);
	}
	

}
