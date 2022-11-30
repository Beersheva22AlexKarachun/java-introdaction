package telran.digital.numbers;

import static telran.digital.numbers.Digits.*;

import java.util.Arrays;

public class DigitalNumbersPrinting {
	private static final int LETTER_INTERVAL = 2;
	private static final int MIN_WIDTH = 3;
	private static final int MIN_HEIGHT = 5;

	public static void displayDigitalNumber(int number, int offset, int width, int height) {
		width = width > MIN_WIDTH - 1 ? width : MIN_WIDTH;
		height = height > MIN_HEIGHT - 1 ? height : MIN_HEIGHT;
		String[] res = getDigitalNumber(number, offset, width, height);
		displayStrings(res);
	}

	private static int getNdigits(long number) {
		int res = 0;
		do {
			number /= 10;
			res++;
		} while (number != 0);
		return res;
	}

	private static int[] getDigits(int number) {
		int res[] = new int[getNdigits(number)];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
		return res;
	}

	private static String[] getDigitalNumber(int number, int offset, int width, int height) {
		int[] digits = getDigits(number);
		String[] res = getArrayDigit(digits[0], offset, width, height);
		for (int i = 1; i < digits.length; i++) {
			res = addArrayDigit(res, getArrayDigit(digits[i], LETTER_INTERVAL, width, height));
		}
		return res;
	}

	private static String[] addArrayDigit(String[] accum, String[] operand) {
		String[] res = accum;
		for (int i = 0; i < accum.length; i++) {
			res[i] += operand[i];
		}
		return res;
	}

	private static String[] getArrayDigit(int digit, int offset, int width, int height) {
		String[] res = new String[height];
		switch (digit) {
		case 0:
			res = zero(offset, width, height);
			break;
		case 1:
			res = one(offset, width, height);
			break;
		case 2:
			res = two(offset, width, height);
			break;
		case 3:
			res = three(offset, width, height);
			break;
		case 4:
			res = four(offset, width, height);
			break;
		case 5:
			res = five(offset, width, height);
			break;
		case 6:
			res = six(offset, width, height);
			break;
		case 7:
			res = seven(offset, width, height);
			break;
		case 8:
			res = eight(offset, width, height);
			break;
		case 9:
			res = nine(offset, width, height);
			break;
		}
		return res;
	}

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
}