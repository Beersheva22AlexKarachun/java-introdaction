package telran.digital.numbers;

public class Digits {
	private static final String SYMBOL = "*";

	public static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		res[0] = line;
		String[] lines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] = line;
		return res;
	}

	public static String[] one(int offset, int width, int height) {
		return rightVerticalLine(offset, width, height);
	}

	public static String[] two(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		int middle = getMiddlePoint(height);
		res[0] = line;
		String[] insertedLines = rightVerticalLine(offset, width, middle - 1);
		System.arraycopy(insertedLines, 0, res, 1, insertedLines.length);
		res[middle] = line;
		insertedLines = leftVerticalLine(offset, width, height - middle - 2);
		System.arraycopy(insertedLines, 0, res, middle + 1, insertedLines.length);
		res[height - 1] = line;
		return res;
	}

	public static String[] three(int offset, int width, int height) {
		String[] res = one(offset, width, height);
		String line = line(offset, width);
		int middle = getMiddlePoint(height);
		res[0] = line;
		res[middle] = line;
		res[height - 1] = line;
		return res;
	}

	public static String[] four(int offset, int width, int height) {
		String[] res = new String[height];
		int middle = getMiddlePoint(height);
		String[] insertedLines = twoVerticalLines(offset, width, middle);
		System.arraycopy(insertedLines, 0, res, 0, insertedLines.length);
		res[middle] = line(offset, width);
		insertedLines = rightVerticalLine(offset, width, height - middle - 1);
		System.arraycopy(insertedLines, 0, res, middle + 1, insertedLines.length);
		return res;
	}

	public static String[] five(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		int middle = getMiddlePoint(height);
		res[0] = line;
		String[] insertedLines = leftVerticalLine(offset, width, middle - 1);
		System.arraycopy(insertedLines, 0, res, 1, insertedLines.length);
		res[middle] = line;
		insertedLines = rightVerticalLine(offset, width, height - middle - 2);
		System.arraycopy(insertedLines, 0, res, middle + 1, insertedLines.length);
		res[height - 1] = line;
		return res;
	}

	public static String[] six(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		int middle = getMiddlePoint(height);
		res[0] = line;
		String[] insertedLines = leftVerticalLine(offset, width, middle - 1);
		System.arraycopy(insertedLines, 0, res, 1, insertedLines.length);
		res[middle] = line;
		insertedLines = twoVerticalLines(offset, width, height - middle - 2);
		System.arraycopy(insertedLines, 0, res, middle + 1, insertedLines.length);
		res[height - 1] = line;
		return res;
	}

	public static String[] seven(int offset, int width, int height) {
		String[] res = one(offset, width, height);
		res[0] = line(offset, width);
		return res;
	}

	public static String[] eight(int offset, int width, int height) {
		String[] res = zero(offset, width, height);
		int middle = getMiddlePoint(height);
		res[middle] = line(offset, width);
		return res;
	}

	public static String[] nine(int offset, int width, int height) {
		String[] res = new String[height];
		String line = line(offset, width);
		int middle = getMiddlePoint(height);
		res[0] = line;
		String[] insertedLines = twoVerticalLines(offset, width, middle - 1);
		System.arraycopy(insertedLines, 0, res, 1, insertedLines.length);
		res[middle] = line;
		insertedLines = rightVerticalLine(offset, width, height - middle - 2);
		System.arraycopy(insertedLines, 0, res, middle + 1, insertedLines.length);
		res[height - 1] = line;
		return res;
	}

	private static int getMiddlePoint(int height) {
		return (height - 1) / 2;
	}

	private static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	private static String[] rightVerticalLine(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset + width - 1) + SYMBOL;
		}
		return res;
	}

	private static String[] leftVerticalLine(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 1);
		}
		return res;
	}

	private static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}
}
