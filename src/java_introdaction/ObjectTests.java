package java_introdaction;


import static org.junit.jupiter.api.Assertions.*;
import static telran.Strings.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.Strings;

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



}