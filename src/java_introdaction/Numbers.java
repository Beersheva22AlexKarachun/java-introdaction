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
}