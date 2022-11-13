package java_introdaction;

import java.util.Arrays;

public class MyArrays {

	public static void main(String[] args) {
		int[] array = { 5, 4, 3, 2, 1 };
		System.out.println(isSorted(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(isSorted(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(isSorted(new int[] { 5, 4, 2, 1, 3 }));

	}

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
	 * @return index of first number if number exists otherwise -index - 1
	 */
	public static int binarySearch(int[] arraySorted, int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;

		while (left <= right
				&& !(arraySorted[middle] == number && (middle == 0 || arraySorted[middle - 1] < arraySorted[middle]))) {
			if (number <= arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (right + left) / 2;
		}
		return left > right ? (-middle - 1) : middle;
	}

	/**
	 * 
	 * @param array
	 * @return true if the array is unsorted but only one swap between two numbers
	 *         is required for getting a sorted array
	 */
	public static boolean isOneSwapForSorted(int[] array) {
		boolean res = false;
		int wrongOrderCounter = 0;
		int[] indexesOfWrongOrderedNumbers = new int[3];
		int i = 0;
		while (wrongOrderCounter < 3 && i < array.length - 1) {
			if (array[i] > array[i + 1]) {
				wrongOrderCounter++;
				indexesOfWrongOrderedNumbers[wrongOrderCounter - 1] = i;
			}
			i++;
		}
		// Numbers to be swapped are not next to each other
		if (wrongOrderCounter == 2) {
			final int FIRST_INDEX = indexesOfWrongOrderedNumbers[0];
			final int SECOND_INDEX = indexesOfWrongOrderedNumbers[1];

			// Numbers to be swapped are on the edges of the array.
			if (FIRST_INDEX == 0 && SECOND_INDEX == array.length - 2) {
				res = array[FIRST_INDEX] >= array[SECOND_INDEX] && array[SECOND_INDEX + 1] <= array[FIRST_INDEX + 1];
				// The first number is in the first position of the array
			} else if (FIRST_INDEX == 0) {
				res = (array[FIRST_INDEX] >= array[SECOND_INDEX - 1] && array[FIRST_INDEX] <= array[SECOND_INDEX + 2])
						&& array[SECOND_INDEX + 1] <= array[FIRST_INDEX + 1];
				// The second number is in the last position of the array
			} else if (SECOND_INDEX == array.length - 2) {
				res = array[FIRST_INDEX] >= array[SECOND_INDEX - 1] && (array[SECOND_INDEX] <= array[FIRST_INDEX + 1]
						&& array[SECOND_INDEX] >= array[FIRST_INDEX - 1]);
				// Both are in the middle of the array
			} else {
				res = (array[FIRST_INDEX] >= array[SECOND_INDEX] && array[FIRST_INDEX] <= array[SECOND_INDEX + 2])
						&& (array[SECOND_INDEX + 1] >= array[FIRST_INDEX - 1]
								&& array[SECOND_INDEX + 1] <= array[FIRST_INDEX + 1]);
			}

			// Numbers to be swapped are next to each other
		} else if (wrongOrderCounter == 1) {
			final int FIRST_INDEX = indexesOfWrongOrderedNumbers[0];
			// The first number is in the first position of the array
			if (FIRST_INDEX == 0) {
				res = array[FIRST_INDEX] <= array[FIRST_INDEX + 2];
				// The first number is in the second last position of the array
			} else if (FIRST_INDEX == array.length - 2) {
				res = array[FIRST_INDEX + 1] > array[FIRST_INDEX - 1];
				// Both are in the middle of the array
			} else {
				res = (array[FIRST_INDEX + 1] > array[FIRST_INDEX - 1])
						&& (array[FIRST_INDEX + 2] > array[FIRST_INDEX]);
			}
		}
		return res;
	}

	/**
	 * 
	 * @param array
	 * @return sorted array
	 */
	public static int[] bubbleSort(int[] array) {
		if (array != null && !isSorted(array)) {
			for (int i = 0; i < array.length - 1; i++) {
				moveGreaterRight(array, 0, array.length - i - 1);
			}
		}
		return array;
	}

	public static boolean isSorted(int[] array) {
		boolean res = true;
		for (int i = 0; i < array.length - 2; i++) {
			if (array[i] > array[i + 1]) {
				res = false;
				break;
			}
		}
		return res;
	}

	private static void moveGreaterRight(int[] array, int start, int end) {
		for (int i = start; i < end; i++) {
			if (array[i] > array[i + 1]) {
				swapIndexes(array, i, i + 1);
			}
		}
	}

	private static void swapIndexes(int[] array, int firstIndex, int secondIndex) {
		int temp = 0;
		temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;

	}
}
