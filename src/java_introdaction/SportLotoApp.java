package java_introdaction;

import java.util.Random;

public class SportLotoApp {

	/**
	 * App displays out 6 random numbers from 1 to 49 numbers can't be repeated in a
	 * sequence
	 */
	public static void main(String[] args) {
		System.out.print("100" + " " + 200);
	}


	public static int getRandomInt(int min, int max) {
		return (int) (min + Math.random() * (max - min));
	}

}
