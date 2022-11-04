package java_introdaction;

public class Numbers {

	static public int getNdigits(long number) {
		int res = 0;
		do {
			number /= 10;
			res++;
		} while (number != 0);
		return res;
	}

	/**
	 * 
	 * @param number - signed number
	 * @param nDigit - number of digit [0..n]
	 * @return
	 */
	static public int getNdigit(long number, int nDigit) {
		int res = -1;
		number = Math.abs(number);

		if (nDigit <= (getNdigits(number) - 1)) {
			for (int i = 0; i < nDigit; i++) {
				number /= 10;
			}
			res = (int) number % 10;
		}
		return res;
	}

	/**
	 * @param number
	 * @return true only if number has 6 digits and sum of 1-3 equals sum 4-6.
	 */
	static public boolean isLuckyNumber(long number) {
		int firstTripletSum = 0;
		int secondTripletSum = 0;
		boolean res = false;
		if (number >= 100000 && number <= 999999) {
			for (int i = 0; i < 3; i++) {
				firstTripletSum += getNdigit(number, i);
				secondTripletSum += getNdigit(number, i + 3);
			}
			res = firstTripletSum == secondTripletSum;
		}
		return res;

	}
}