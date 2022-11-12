package java_introdaction;

import java.util.Arrays;

public class MyArrays {
	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array with added number
	 */
	public static int[] addNumber(int[] array, int number) {
		int[] newArray = Arrays.copyOf(array, array.length + 1);
		newArray[newArray.length - 1] = number;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array without number with given index in a given array if index
	 *         doesn't exist in a given array it returns the same array
	 */
	public static int[] removeNumber(int[] array, int index) {
		int[] res = array;
		if (checkIndexRange(index, array.length)) {
			res = new int[array.length - 1];
			System.arraycopy(array, 0, res, 0, index);
			System.arraycopy(array, index + 1, res, index, array.length - index - 1);
		}
		return res;
	}

	private static boolean checkIndexRange(int index, int arrayLength) {
		return (index > -1 && index < arrayLength) ? true : false;
	}

	/**
	 * 
	 * @param array
	 * @param number
	 * @return new sorted array with inserted number
	 */
	public static int[] insertSorted(int[] array, int number) {
		int insertionPoint = Arrays.binarySearch(array, number);
		insertionPoint = Numbers.isPositive(insertionPoint) ? insertionPoint : Math.abs(insertionPoint) - 1;
		return insertAtIndex(array, number, insertionPoint);
	}

	private static int[] insertAtIndex(int[] array, int number, int index) {
		int[] res = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index, res, index + 1, array.length - index);
		res[index] = number;
		return res;
	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index if number exist otherwise -1
	 */
	public static int binarySearch(int[] arraySorted, int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;

		while (left <= right && arraySorted[middle] == number) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (right + left) / 2;

		}
		return left > right ? -1 : middle;
	}

	public static boolean isOneSwapForSorted(int[] array) {
		boolean res = false;
		int wrongOrderCounter = 0;
		int[] indexes = new int[3];
		int i = 0;
		while (wrongOrderCounter < 3 && i < array.length - 1) {
			if (array[i] > array[i + 1]) {
				wrongOrderCounter++;
				indexes[wrongOrderCounter - 1] = i;
			}
			i++;
		}

		if (2 == wrongOrderCounter) {
			final int FIRST_INDEX = indexes[0];
			final int SECOND_INDEX = indexes[1];

			if (FIRST_INDEX == 0 && SECOND_INDEX == array.length - 2) {
				res = array[FIRST_INDEX] >= array[SECOND_INDEX] && array[SECOND_INDEX + 1] <= array[FIRST_INDEX + 1];

			} else if (FIRST_INDEX == 0) {
				res = (array[FIRST_INDEX] >= array[SECOND_INDEX - 1] && array[FIRST_INDEX] <= array[SECOND_INDEX + 2])
						&& array[SECOND_INDEX + 1] <= array[FIRST_INDEX + 1];

			} else if (SECOND_INDEX == array.length - 2) {
				res = array[FIRST_INDEX] >= array[SECOND_INDEX - 1] && (array[SECOND_INDEX] <= array[FIRST_INDEX + 1]
						&& array[SECOND_INDEX] >= array[FIRST_INDEX - 1]);

			} else {
				res = (array[FIRST_INDEX] >= array[SECOND_INDEX] && array[FIRST_INDEX] <= array[SECOND_INDEX + 2])
						&& (array[SECOND_INDEX + 1] >= array[FIRST_INDEX - 1]
								&& array[SECOND_INDEX + 1] <= array[FIRST_INDEX + 1]);
			}

		} else if (1 == wrongOrderCounter) {
			final int FIRST_INDEX = indexes[0];
			if (FIRST_INDEX == 0) {
				res = array[FIRST_INDEX] <= array[FIRST_INDEX + 2];
			} else if (FIRST_INDEX == array.length - 2) {
				res = array[FIRST_INDEX + 1] > array[FIRST_INDEX - 1];
			} else {
				res = (array[FIRST_INDEX + 1] > array[FIRST_INDEX - 1]) && (array[FIRST_INDEX + 2] > array[FIRST_INDEX]);
			}
		}
		return res;
	}

	public static boolean isOneSwapForSortedInf(int[] array) {
		boolean res = false;
		int wrongOrderCounter = 0;
		int[] indexes = new int[3];
		int i = 0;

		while (wrongOrderCounter < 3 && i < array.length - 1) {
			if (array[i] > array[i + 1]) {
				wrongOrderCounter++;
				indexes[wrongOrderCounter - 1] = i + 1;
			}
			i++;
		}
		
		if (wrongOrderCounter == 1 || wrongOrderCounter == 2) {
			int[] arrayWithInf = new int[array.length + 2];
			System.arraycopy(array, 0, arrayWithInf, 1, array.length);
			arrayWithInf[0] = Integer.MIN_VALUE;
			arrayWithInf[arrayWithInf.length - 1] = Integer.MAX_VALUE;
			final int FIRST_INDEX = indexes[0];

			if (2 == wrongOrderCounter) {
				final int SECOND_INDEX = indexes[1];

				res = (arrayWithInf[FIRST_INDEX] >= arrayWithInf[SECOND_INDEX]
						&& arrayWithInf[FIRST_INDEX] <= arrayWithInf[SECOND_INDEX + 2])
						&& (arrayWithInf[SECOND_INDEX + 1] >= arrayWithInf[FIRST_INDEX - 1]
								&& arrayWithInf[SECOND_INDEX + 1] <= arrayWithInf[FIRST_INDEX + 1]);

			} else if (1 == wrongOrderCounter) {

				res = (arrayWithInf[FIRST_INDEX + 1] > arrayWithInf[FIRST_INDEX - 1])
						&& (arrayWithInf[FIRST_INDEX + 2] > arrayWithInf[FIRST_INDEX]);
			}
		}
		return res;
	}
}
