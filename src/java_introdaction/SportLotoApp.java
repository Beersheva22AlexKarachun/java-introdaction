package java_introdaction;

import java.util.ArrayList;

public class SportLotoApp {
	static int  MIN_VALUE = 1;
	static int MAX_VALUE = 10;

	/**
	 * App displays out 6 random numbers from 1 to 49 numbers can't be repeated in a
	 * sequence
	 */
	public static void main(String[] args) {
//		ArrayList<Integer> data = new ArrayList<Integer>();
//
//		for (int i = 0; i < 1000000; i++) {
//			data.add(getRandomInt(MIN_VALUE, MAX_VALUE));
//		}
//		for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
//			System.out.println(getAmountOfNumberInList(data, k) / (double) data.size());
//		}
//		System.out.println(data.size());
		SportLoto();
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

	public static void SportLoto() {
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		int num6 = 0;
		do {
			num1 = getRandomInt(1, 49);
			num2 = getRandomInt(1, 49);
			num3 = getRandomInt(1, 49);
			num4 = getRandomInt(1, 49);
			num5 = getRandomInt(1, 49);
			num6 = getRandomInt(1, 49);
		} while (isDiffNumbers(num1, num2, num3, num4, num5, num6) != true);
		System.out.println(num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6);
	}

	public static boolean isDiffNumbers(int num1, int num2, int num3, int num4, int num5, int num6) {
		return ((num1 != num2 && num1 != num3 && num1 != num4 && num1 != num5 && num1 != num6) &&
				(num2 != num3 && num2 != num4 && num2 != num5 && num2 != num6) &&
				(num3 != num4 && num3 != num5 && num3 != num6) &&
				(num4 != num5 && num4 != num6) &&
				(num5 != num6)) ? true : false;
	}
}
