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
		return left > right ? -1: middle;
	}
}
