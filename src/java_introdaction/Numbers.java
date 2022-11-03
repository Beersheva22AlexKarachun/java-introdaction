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
	 * @return true only if number has 6 digits and sum of 1-3 equals sum 4-6.
	 */
	static public boolean isLuckyNumber(long number) {
		// TODO
		return false;
	}
}