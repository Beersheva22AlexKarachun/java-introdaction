package java_introdaction;

/**
 * valid nBit values [0, 63] - all methods will return -1 in the case of wrong
 * nBit value
 */

public class BitOperations {
	private static final int N_BITS = 64;

	/**
	 * @param number - any number
	 * @param nBit   - number of bit
	 * @return value of bit with number nBit
	 */
	static public int getBitValue(long number, int nBit) {
		int res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit);
			res = ((number & mask) == 0) ? 0 : 1;
		}
		return res;
	}

	private static boolean checkNbit(int nBit) {
		return nBit < N_BITS && nBit > -1;
	}

	private static long getMask(int n) {
		return 1L << n;
	}

	/**
	 * @param number - any number
	 * @param nBit   - bit number
	 * @param value  - true for 1 / false for 0
	 * @return new number in which value of bit will have a given value
	 */
	static public long setBitValue(long number, int nBit, boolean value) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit);
			res = value ? (number | mask) : (number & ~mask);
		}
		return res;
	}

	/**
	 * @param number - any number
	 * @param nBit   - bit number
	 * @return new number in which nBit'h will be inverted
	 */
	static public long invertBitValue(long number, int nBit) {
		return checkNbit(nBit) ? (number ^ getMask(nBit)) : -1;
	}

	static public int leadingZeros(long number) {
		int res = 0;
		int nBit = N_BITS - 1;
		while (nBit >= 0 && getBitValue(number, nBit) == 0) {
			res++;
			nBit--;
		}
		return res;
	}

	static public int onesInNumber(long number) {
		int res = 0;
		for (int i = 0; i < N_BITS; i++) {
			res += getBitValue(number, i);
		}
		return res;
	}
}