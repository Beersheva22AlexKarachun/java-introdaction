package telran.text;

import java.util.Arrays;

public class Strings {
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1 complexity O[N] two passes only
	 *         one additional array only symbols or English letters 1. the same
	 *         length 2. the same symbols just in different order
	 */
	public static boolean isAnagram(String str1, String str2) {
		int j = 0;
		int str1Length = str1.length();
		if (str1Length == str2.length()) {
			int[] charCounter = new int[Character.MAX_VALUE];
			for (int i = 0; i < str1Length; i++) {
				charCounter[(int) str1.charAt(i)]++;
				charCounter[(int) str2.charAt(i)]--;
			}
			while (j < charCounter.length && charCounter[j] == 0) {
				j++;
			}
		}
		return j == Character.MAX_VALUE;
	}

	/**
	 * The method sorts input array of Strings on the place
	 * 
	 * @param arrayOfStrings
	 */
	public static void sortStringNumbers(String[] arrayOfStrings) {
		short offset = Byte.MAX_VALUE + 1;
		int[] helper = new int[offset * 2];
		int j = 0;
		int index = 0;
		for (int i = 0; i < arrayOfStrings.length; i++) {
			helper[Byte.parseByte(arrayOfStrings[i]) + offset]++;
		}
		while (index < arrayOfStrings.length) {
			if (helper[j] == 0) {
				j++;
			} else {
				arrayOfStrings[index] = Integer.toString(j - offset);
				index++;
				helper[j]--;
			}
		}
	}

	public static String javaNameExp() {
		return "([a-zA-Z$][\\w$]*|_[\\w$]+)";
	}

	public static String ipV4Octet() {
		return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
	}

	public static String ipV4() {
		String octetExp = ipV4Octet();
		return String.format("(%1$s\\.){3}%1$s", octetExp);
	}

	public static String arithmeticExp() {
		String operatorExp = operatorExp();
		String operandExp = operandExp();

		return String.format("\\(*%1$s(%2$s\\(*%1$s\\)*)*", operandExp, operatorExp);
	}

	public static String numberExp() {
		return "(\\d+\\.?\\d*|\\.\\d+)";
	}

	public static String operandExp() {
		return String.format("(%s|%s)", numberExp(), javaNameExp());
	}

	private static String operatorExp() {

		return "([-+*/])";
	}

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExp());
	}

	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variable names sorted
	 * @return computed value of a given expression or Double.NaN
	 */
	public static Double computeArithmenticExpression(String expression, double values[], String names[]) {
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String operands[] = expression.split(operatorExp());
			String operators[] = expression.split(operandExp());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}

		}

		return res;
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		Double res = Double.NaN;
		if (!Double.isNaN(operand2)) {
			switch (operator) {
			case "+":
				res = operand1 + operand2;
				break;
			case "-":
				res = operand1 - operand2;
				break;
			case "*":
				res = operand1 * operand2;
				break;
			case "/":
				res = operand1 / operand2;
				break;
			default:
				res = Double.NaN;
			}
		}
		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		Double res = Double.NaN;
		if (operand.matches(numberExp())) {
			res = Double.parseDouble(operand);
		} else {
			int index = Arrays.binarySearch(names, operand);
			res = (index > -1) ? values[index] : res;
		}
		return res;
	}

	public static boolean checkBraces(String expression) {
		int count = 0, i = 0, length = expression.length();
		while (i < length && count > -1) {
			char symbol = expression.charAt(i);
			if (symbol == '(') {
				count++;
			} else if (symbol == ')') {
				count--;
			}
			i++;
		}
		return count == 0;
	}

}