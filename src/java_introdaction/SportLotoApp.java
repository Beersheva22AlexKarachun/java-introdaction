package java_introdaction;

import java.util.ArrayList;

public class SportLotoApp {
	static int  MIN_VALUE = 1;
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

	/**
	 * The method generates 6 different number in range [min, max] and prints it.
	 */
	public static void getSportLotoSet(int min, int max) {
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		int num6 = 0;
		do {
			num1 = getRandomInt(min, max);
			num2 = getRandomInt(min, max);
			num3 = getRandomInt(min, max);
			num4 = getRandomInt(min, max);
			num5 = getRandomInt(min, max);
			num6 = getRandomInt(min, max);
		} while (isDiffNumbers(num1, num2, num3, num4, num5, num6) != true);
		
		System.out.println(num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6);
	}
	
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @param num3
	 * @param num4
	 * @param num5
	 * @param num6
	 * @return - returns true if all six number are different, else - false.
	 */
	public static boolean isDiffNumbers(int num1, int num2, int num3, int num4, int num5, int num6) {
		return ((num1 != num2 && num1 != num3 && num1 != num4 && num1 != num5 && num1 != num6) &&
				(num2 != num3 && num2 != num4 && num2 != num5 && num2 != num6) &&
				(num3 != num4 && num3 != num5 && num3 != num6) &&
				(num4 != num5 && num4 != num6) &&
				(num5 != num6)) ? true : false;
	}
}
