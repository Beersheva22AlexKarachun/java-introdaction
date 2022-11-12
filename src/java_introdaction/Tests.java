package java_introdaction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void operatorsTest() {
		int a = 10;
		assertEquals(13, a + 3);
		assertEquals(1, a % 3);
		int number = 123;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));
	}

	private Integer getFirstDigit(int number) {
		number = number / 100;
		int x = number % 10;
		return x;
	}

	private Integer getSecondDigit(int number) {
		number = number / 10;
		int y = number % 10;
		return y;
	}

	private Integer getThirdDigit(int number) {
		int a = number % 10;
		return a;
	}

	@Test
	@Disabled
	void getBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(-1, BitOperations.getBitValue(number, -2));
	}

	@Test
	@Disabled
	void setBitValueTest() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 11_1_1 0101
		assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
	}

	@Test
	@Disabled
	void revertBitValueTest() {
		long number = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));

	}

	@Test
	@Disabled
	void negativeNumberTest() {
		long number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}

	@Test
	@Disabled
	void leadingZerosTest() {
		long number = 1L;
		assertEquals(63, BitOperations.leadingZeros(number));
		number = -1L;
		assertEquals(0, BitOperations.leadingZeros(number));
		number = 0l;
		assertEquals(0, BitOperations.leadingZeros(BitOperations.setBitValue(number, 63, true)));
	}

	@Test
	@Disabled
	void onesInNumberTest() {
		long number = 3;
		assertEquals(2, BitOperations.onesInNumber(number));
	}

	@Test
	@Disabled
	void isLuckyNumberTest() {
		long number = 1234;
		assertEquals(false, Numbers.isLuckyNumber(number));
		number = 123456;
		assertEquals(false, Numbers.isLuckyNumber(number));
		number = 123321;
		assertEquals(true, Numbers.isLuckyNumber(number));
		number = 423630;
		assertEquals(true, Numbers.isLuckyNumber(number));
	}

	@Test
	@Disabled
	void getDigitsTest() {
		int[] expected = { 1, 2, 3, 4 };
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}

	@Test
	@Disabled
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[] { 1, 2, 3, 4 }));
	}

	@Test
	@Disabled
	void additionalNumbersTest() {
		assertEquals(5, Numbers.getSumOfDigits(23));
		assertEquals(5, Numbers.getSumOfDigits(5));
		assertEquals(7, Numbers.getSumOfDigits(61));
		assertEquals(0, Numbers.getSumOfDigits(0));
	}

	@Test
	@Disabled
	void idTest() {
		int id = 123456782;
		assertEquals(40, IsraelIdentity.getIdControlSum(id));
		assertTrue(IsraelIdentity.verify(id));
		for (int i = 0; i < 100; i++) {
			assertTrue(IsraelIdentity.verify(IsraelIdentity.generateRandomId()));
		}
		// assertEquals(10, IsraelIdentity.generateRandomId());
	}

	@Test
	@Disabled
	void isNegativeIntTest() {
		assertTrue(Numbers.isNegaiveInt(-50));
		assertTrue(Numbers.isNegaiveInt(-5));
		assertFalse(Numbers.isNegaiveInt(50));
	}

	@Test
	@Disabled
	void myArraysTest() {
		int[] array = { 1, 2, 3 };
		array = MyArrays.addNumber(array, 4);
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, array);
		array = MyArrays.addNumber(array, 5);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);

		array = new int[] { 1, 2, 3, 4, 5, 6 };
		assertArrayEquals(new int[] { 1, 2, 4, 5, 6 }, MyArrays.removeNumber(array, 2));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, MyArrays.removeNumber(array, 5));
		assertArrayEquals(array, MyArrays.removeNumber(array, 10));

		array = new int[] { 1, 2, 3, 5, 6 };
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, MyArrays.insertSorted(array, 4));
		assertArrayEquals(new int[] { 1, 2, 3, 5, 6, 10 }, MyArrays.insertSorted(array, 10));
		assertArrayEquals(new int[] { 0, 1, 2, 3, 5, 6 }, MyArrays.insertSorted(array, 0));
		assertArrayEquals(new int[] { 1, 2, 3, 3, 5, 6 }, MyArrays.insertSorted(array, 3));
		assertArrayEquals(new int[] { -5, 1, 2, 3, 5, 6 }, MyArrays.insertSorted(array, -5));

	}

	@Test
//	@Disabled
	void isOneSwapTestFalse() {
		int ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		int ar2[] = { 1, 2, 3, 4, 5, 10 };
		int ar3[] = { 5, 1, 2, 4, 6, 10 };
		int ar4[] = { 1, 5, 2, 4, 3, 10 };
		int ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
		int ar6[] = { 1, 3, 20, 4, 5, 6, 10 };
		int ar7[] = { 1, 3, 20, 4, 5, 11, 2 };
		assertFalse(MyArrays.isOneSwapForSortedInf(ar1));
		assertFalse(MyArrays.isOneSwapForSortedInf(ar2));
		assertFalse(MyArrays.isOneSwapForSortedInf(ar3));
		assertFalse(MyArrays.isOneSwapForSortedInf(ar4));
		assertFalse(MyArrays.isOneSwapForSortedInf(ar5));
		assertFalse(MyArrays.isOneSwapForSortedInf(ar6));
		assertFalse(MyArrays.isOneSwapForSortedInf(ar7));
	}

	@Test
//	@Disabled
	void isOneSwapTestTrue() {
		System.out.println("---");
		int ar1[] = { 10, 2, 3, 4, 1 };
		int ar2[] = { 1, 2, 4, 3, 5, 10 };
		int ar3[] = { 1, 2, 3, 10, 5, 4 };
		int ar4[] = { 1, 5, 3, 4, 2, 10 };
		int ar5[] = { 1, 2, 3, 4, 10, 5 };
		int ar6[] = { 2, 1, -3, 4, 5, 10 };
		int ar7[] = { 3, 2, 1, 4, 5, 6 };
		assertTrue(MyArrays.isOneSwapForSortedInf(ar1));
		assertTrue(MyArrays.isOneSwapForSortedInf(ar2));
		assertTrue(MyArrays.isOneSwapForSortedInf(ar3));
		assertTrue(MyArrays.isOneSwapForSortedInf(ar4));
		assertTrue(MyArrays.isOneSwapForSortedInf(ar5));
		assertTrue(MyArrays.isOneSwapForSortedInf(ar6));
		assertTrue(MyArrays.isOneSwapForSortedInf(ar7));
}
}
