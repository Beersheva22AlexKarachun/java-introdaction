package java_introdaction;

public class IsraelIdentity {
	/**
	 * 
	 * @param id
	 * @return true if ID is correct otherwise false
	 * control sum should be divided by 10 with no remainder (multiple of 10)
	 * for even indexes digits as it is
	 * for odd indexes digit = digit * 2, if > 9 - the sum of its digits
	 * example 123456782 1 + 4 + 3 + 8 + 5 + 3 + 7 + 7 + 2 = 40
	 */
	public static boolean verify(int id) {
		boolean res = false;
		//TODO
		return res;
	}
	
	/**
	 * 
	 * @return random number of 9 digits matching right Israel id
	 * No more then 9 iterations
	 */
	public static int generateRandomId() {
		int newId = 0;
		//TODO
		return newId;
	}
}
