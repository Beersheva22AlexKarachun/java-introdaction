package java_introdaction;

import java.util.ArrayList;

public class SportLotoApp {
	static int MIN_VALUE = 1;
	static int MAX_VALUE = 49;

	/**
	 * App displays out 6 random numbers from 1 to 49 numbers can't be repeated in a
	 * sequence
	 */
	public static void main(String[] args) {
		getSportLotoSet(MIN_VALUE, MAX_VALUE);
	}

	public static long getAmountOfNumberInList(ArrayList<Integer> list1, long number) {
		long res = 0l;
		for (int i = 0; i < list1.size(); i++) {
			res += list1.get(i) == number ? 1 : 0;
		}
		return res;
	}

	public static int getRandomInt(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));

	}

	public static boolean checkNumberRange(int number, int min, int max) {
		return (number >= min && number <= max) ? true : false;
	}

	/**
	 * The method generates 6 different number in range [min, max] and prints it.
	 */
	public static void getSportLotoSet(int min, int max) {
		long mask = 0L;
		int count = 0;
		int number = 0;
		while (count < 6) {
			number = getRandomInt(min, max);
			if (BitOperations.getBitValue(mask, number) == 0) {
				mask = BitOperations.setBitValue(mask, number, true);
				count++;
				System.out.print(number + " ");
			}
		}
	}
}
