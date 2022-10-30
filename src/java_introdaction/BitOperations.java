package java_introdaction;

/**
 * valid nBit values [0, 63] - all methods will return -1 in the case of wrong
 * nBit value
 */

public class BitOperations {

	/**
	 * @param number - any number
	 * @param nBit   - number of bit
	 * @return value of bit with number nBit
	 */
	static public int getBitValue(long number, int nBit) {
		int res = -1;
		if (checkNbit(nBit)) {
			long mask = 1 << nBit;
			res = ((number & mask) == 0) ? 0 : 1;
		}
		return res;
	}

	private static boolean checkNbit(int nBit) {
		return nBit < 64 && nBit > -1;
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
			long mask = 1 << nBit;
			res = value ? (number | mask) : (number & ~mask);
		}
		return res;
	}

	/**
	 * @param number - any number
	 * @param nBit   - bit number
	 * @return new number in which nBit'h will be replaced (old value 0 new value 1)
	 */
	static public long revertBitValue(long number, int nBit) {
		long res = -1;
		if (checkNbit(nBit)) {
			int bitValue = getBitValue(number, nBit);
			long mask = 1 << nBit;
			res = (bitValue == 0) ? (number | mask) : (number & ~mask);
		}
		return res;
	}
}
