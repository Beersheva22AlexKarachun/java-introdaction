package java_introdaction;

public class Numbers {

	static public boolean isEven(int number) {
		return (number % 2 == 0);
	}

	static public int getNdigits(long number) {
		int res = 0;
		do {
			number /= 10;
			res++;
		} while (number != 0);
		return res;
	}

	/**
	 * @param number
	 * @return true only if number is positive, has 6 digits and sum of 1-3 equals
	 *         sum 4-6.
	 */
	static public boolean isLuckyNumber(long number) {
		int firstTripletSum = 0;
		int secondTripletSum = 0;
		boolean res = false;
		int digit = 0;
		if (number >= 100000 && number <= 999999) {
			for (int i = 0; i < 6; i++) {
				digit = (int) number % 10;
				number /= 10;
				if (i < 3) {
					firstTripletSum += digit;
				} else {
					secondTripletSum += digit;
				}
				res = firstTripletSum == secondTripletSum;
			}
		}
		return res;
	}

	public static int[] getDigits(int number) {
		int res[] = new int[getNdigits(number)];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
		return res;
	}

	public static int getNumberFromDigits(int[] digits) {
		int res = 0;
		for (int i = 0; i < digits.length; i++) {
			res = res * 10 + digits[i];
		}
		return res;
	}

	public static int getSumOfDigits(int number) {
		int res = 0;
		int[] digits = getDigits(number);
		number = Math.abs(number);
		for (int i = 0; i < digits.length; i++) {
			res += digits[i];
		}
		return res;
	}

	public static int getRandomInt(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
	
	public static long getRandomLong(long min, long max) {
		return (min + (long) Math.random() * (max - min + 1));
	}
	
	public static boolean isNegaiveInt(int number) {
		return BitOperations.getBitValue(number, 31) == 1;
	}
	
	public static boolean isPositive(int number) {
		return BitOperations.getBitValue(number, 31) == 0;
	}
}