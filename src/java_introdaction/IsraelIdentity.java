package java_introdaction;

public class IsraelIdentity {
	static final int ID_LENGHT = 9;

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
		if (Numbers.getNdigits(id) == ID_LENGHT) {
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
		int res = 0;
		int[] digits = Numbers.getDigits(id);
		for (int i = 0; i < digits.length; i++) {
			res += Numbers.isEven(i) ? digits[i] : Numbers.getSumOfDigits(digits[i] * 2);
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
