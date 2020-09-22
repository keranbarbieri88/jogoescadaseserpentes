package jogoescadaseserpentes;

import java.util.Random;

public class Dice {

	private static final  int MAX_NUMBER = 6;
	private static Dice instance;
	
	private Random random = new Random();
	
	private Dice() {
		
	}
	/*
	 * Singleton - retorna sempre a mesma inst�ncia
	 */
	public static Dice get() {
		if(instance == null) {
		instance =  new Dice();
	}
		return instance;
  }
	public int roll() {
		return random.nextInt(MAX_NUMBER) + 1;
		
	}
}
