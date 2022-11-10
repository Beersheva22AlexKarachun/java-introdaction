package java_introdaction;

public class IsraelIdentity {
	static final int ID_LENGTH = 9;

	/**
	 * 
	 * @param id
	 * @return true if ID is correct otherwise false control sum should be divided
	 *         by 10 with no remainder (multiple of 10) for even indexes digits as
	 *         it is, for odd indexes digit = digit * 2, if > 9 - the sum of its
	 *         digits example 123456782 1 + 4 + 3 + 8 + 5 + 3 + 7 + 7 + 2 = 40
	 */
	public static boolean verify(int id) {
		boolean res = false;
		if (id > 0 && Numbers.getNdigits(id) == ID_LENGTH) {
			res = (getIdControlSum(id) % 10 == 0) ? true : false;
		}
		return res;
	}

	/**
	 * 
	 * @param id
	 * @return the sum calculated according to the above rules
	 */
	public static int getIdControlSum(int id) {
		int[] digits = Numbers.getDigits(id);
		return getEvenIndexesSum(digits) + getOddIndexesSum(digits);
	}

	private static int getEvenIndexesSum(int[] digits) {
		int res = 0;
		for (int i = 0; i < digits.length; i += 2) {
			res += digits[i];
		}
		return res;
	}

	private static int getOddIndexesSum(int[] digits) {
		int res = 0;
		int temp = 0;
		for (int i = 1; i < digits.length; i += 2) {
			temp = digits[i] * 2;
			res += temp < 10 ? temp : temp - 9;
		}
		return res;
	}

	/**
	 * 
	 * @return random number of 9 digits matching right Israel id No more then 9
	 *         iterations
	 */
	public static int generateRandomId() {
		int min = (int) Math.pow(10, 7);
		int max = (int) (Math.pow(10, 8) - 1);
		int id = Numbers.getRandomInt(min, max) * 10;
		int addition = (10 - (getIdControlSum(id) % 10)) % 10;
		return id + addition;
	}

}
