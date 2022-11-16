package java_introdaction;

public class Matrices {

	public static int[][] createRandomMatrix(int rows, int columns, int minValue, int maxValue) {
		int res[][] = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				res[i][j] = (int) Numbers.getRandomInt(minValue, maxValue);
			}
		}
		return res;
	}

	public static int[][] transp(int[][] matrix) {
		int[][] res = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				res[i][j] = matrix[j][i];
			}
		}
		return res;
	}

}