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
			int[] newArray = new int[array.length - 1];
			System.arraycopy(array, 0, newArray, 0, index);
			System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
			res = newArray;
		}
		return res;
	}

	public static boolean checkIndexRange(int index, int arrayLenght) {
		return (index >= 0 && index < arrayLenght) ? true : false;
	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return new sorted array with inserted number
	 */
	public static int[] insertSorted(int[] arraySorted, int number) {
		int[] newArray = new int[arraySorted.length + 1];
		int insertionPoint = Arrays.binarySearch(arraySorted, number);
		insertionPoint = Numbers.isPositive(insertionPoint) ? insertionPoint : Math.abs(insertionPoint) - 1;
		System.arraycopy(arraySorted, 0, newArray, 0, insertionPoint);
		System.arraycopy(arraySorted, insertionPoint, newArray, insertionPoint + 1,
				(arraySorted.length - insertionPoint));
		newArray[insertionPoint] = number;
		return newArray;
	}
}
