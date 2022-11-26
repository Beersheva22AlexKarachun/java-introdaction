package telran;

import static org.junit.jupiter.api.Assertions.*;
import static telran.Strings.computeArithmenticExpression;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringsTest {
	@Test
	@Disabled
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('h', helloAr[0]);
		System.out.println((byte) helloAr[0]);
		assertEquals(5, hello.length());
	}

	@Test
	@Disabled
	void isAnagramTest() {
		String word = "yel lo w";
		assertTrue(Strings.isAnagram(word, "low ey l"));
		assertTrue(Strings.isAnagram(word, "  elolyw"));
		assertTrue(Strings.isAnagram(word, "wolley  "));
		assertTrue(Strings.isAnagram(word, "l ol eyw"));

		assertFalse(Strings.isAnagram(word, ""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word, "yello"));
		assertFalse(Strings.isAnagram(word, "yelllo"));
	}

	@Test
	@Disabled
	void sortStringNumbersTest() {
		String[] array = { "20", "11", "-6", "41", "0", "-128", "11", "3", "-15", "-15", "127" };
		String[] expected = { "-128", "-15", "-15", "-6", "0", "3", "11", "11", "20", "41", "127" };
		Strings.sortStringNumbers(array);
		assertArrayEquals(expected, array);
	}

	@Test
	@Disabled
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
	}

	@Test
	@Disabled
	void ipV40OctetTest() {
		assertTrue("5".matches(Strings.ipV4Octet()));
		assertTrue("69".matches(Strings.ipV4Octet()));
		assertTrue("196".matches(Strings.ipV4Octet()));
		assertTrue("255".matches(Strings.ipV4Octet()));

		assertFalse("05".matches(Strings.ipV4Octet()));
		assertFalse("005".matches(Strings.ipV4Octet()));
		assertFalse("050".matches(Strings.ipV4Octet()));
		assertFalse("1105".matches(Strings.ipV4Octet()));
		assertFalse("256".matches(Strings.ipV4Octet()));
		assertFalse(" 5".matches(Strings.ipV4Octet()));
		assertFalse("100 100".matches(Strings.ipV4Octet()));
		assertFalse("00".matches(Strings.ipV4Octet()));
	}

	@Test
	@Disabled
	void ipV40Test() {
		assertTrue("5.5.5.5".matches(Strings.ipV4()));
		assertTrue("50.1.100.2".matches(Strings.ipV4()));
		assertTrue("0.255.255.255".matches(Strings.ipV4()));
		assertTrue("1.0.168.192".matches(Strings.ipV4()));

		assertFalse("05.100.100.100".matches(Strings.ipV4()));
		assertFalse("010.0222.20.20".matches(Strings.ipV4()));
		assertFalse("15.16.90".matches(Strings.ipV4()));
		assertFalse("50.50.250.20.10".matches(Strings.ipV4()));
		assertFalse("256.0.0.0".matches(Strings.ipV4()));
		assertFalse(" 256.0.0.0 ".matches(Strings.ipV4()));
		assertFalse("05,100.100.100".matches(Strings.ipV4()));
		assertFalse("5,100.100.100".matches(Strings.ipV4()));
		assertFalse("51.0.100".matches(Strings.ipV4()));
		assertFalse("255.255".matches(Strings.ipV4()));
	}

	@Test
	void operandTest() {
		String[] rightOperands = { "100", "15.98", ".67", "number", "ads4" };
		String[] wrongOperands = { "-0100", "15,98", ".67.", "1number", "_" };

		for (int i = 0; i < rightOperands.length; i++) {
			assertTrue(rightOperands[i].matches(Strings.operand()));
			assertFalse(wrongOperands[i].matches(Strings.operand()));
		}
	}

	@Test
	void arithmeticExpressionTest() {
		String[] rightExpressions = { "(9+2", "(((10+5", "(10+((2)+3)))", "a+5)+((11)+b-dump13" };
		String[] wrongExpressions = { "(9+2(", ")10)+5", "10)+2)+3", "a+5)+((11)+b-1dump13" };
		for (int i = 0; i < rightExpressions.length; i++) {
			assertTrue(rightExpressions[i].matches(Strings.arithmeticExpression()));
			assertFalse(wrongExpressions[i].matches(Strings.arithmeticExpression()));
		}
	}

	@Test
	void checkBracesTest() {
		String[] rightExpressions = { "()()(())", "((()))", "()(()())", "((()()())())" };
		String[] wrongExpressions = { "()()(()", ")((()))", "()(()()", "(()()())())" };
		for (int i = 0; i < rightExpressions.length; i++) {
			assertTrue(Strings.checkBraces(rightExpressions[i]));
			assertFalse(Strings.checkBraces(wrongExpressions[i]));
		}
	}

	@Test
	void computeExpressionTest() {
		assertEquals(10.5, computeArithmenticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		assertTrue(Double.isNaN(computeArithmenticExpression("2 # 2 ++ 10", null, null)));
		assertEquals(10.5,
				computeArithmenticExpression("a + 2 + c * 2 + 0.5", new double[] { 2, 1 }, new String[] { "a", "c" }));
		assertTrue(Double.isNaN(
				computeArithmenticExpression("a + 2 + c * 2 + d23", new double[] { 2, 1 }, new String[] { "a", "c" })));
		assertEquals(123, computeArithmenticExpression("one + .5 + two * 3 / three", new double[] { 14, 0.5, 6 },
				new String[] { "one", "three", "two" }));
		assertEquals(15, computeArithmenticExpression("a+b+c+d+g", new double[] { 1, 2, 3, 4, 5 },
				new String[] { "a", "b", "c", "d", "g" }));
	}
}
