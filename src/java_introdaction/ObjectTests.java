package java_introdaction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
	@Disabled
	void wrapperTest() {

		Integer a = 11;

		Integer b = 11;
		assertEquals(a, b);
		Integer c = 201;
		Integer d = 201;
		assertEquals(c, d);
		assertTrue(a == b);
		assertFalse(c == d);
		assertTrue(c.equals(d));
	}

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
	}

}