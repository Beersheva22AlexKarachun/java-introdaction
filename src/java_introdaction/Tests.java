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
	void digitsNumberTest() {
		long number = 1234;
		assertEquals(1, Numbers.getNdigit(number, 3));
		assertEquals(2, Numbers.getNdigit(number, 2));
		assertEquals(3, Numbers.getNdigit(number, 1));
		assertEquals(4, Numbers.getNdigit(number, 0));

		number = 0;
		assertEquals(0, Numbers.getNdigit(number, 0));
		assertEquals(-1, Numbers.getNdigit(number, 2));

		number = -321;
		assertEquals(3, Numbers.getNdigit(number, 2));
		assertEquals(2, Numbers.getNdigit(number, 1));
		assertEquals(1, Numbers.getNdigit(number, 0));
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
	void getDigitsTest() {
		int[] expected = { 1, 2, 3, 4 };
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}

	@Test
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[] { 1, 2, 3, 4 }));
	}
}
