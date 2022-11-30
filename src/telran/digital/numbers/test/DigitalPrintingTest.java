package telran.digital.numbers.test;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.digital.numbers.DigitalNumbersPrinting.*;
import static telran.digital.numbers.Digits.*;


public class DigitalPrintingTest {
	@Test
	@Disabled
	void digitTest() {
		displayStrings(zero(0, 5, 5));
		displayStrings(one(0, 5, 5));
		displayStrings(two(0, 6, 6));
		displayStrings(three(0, 5, 6));
		displayStrings(four(0, 5, 5));
		displayStrings(five(0, 5, 5));
		displayStrings(six(0, 5, 5));
		displayStrings(seven(0, 5, 5));
		displayStrings(eight(0, 5, 5));
		displayStrings(nine(0, 5, 5));

	}
	
	@Test
	void numberTest() {
		int number1 = 1234567890;
		int number2 = 987654321;
		int offset = 5;
		int width = 7;
		int height = 7;
		displayDigitalNumber(number1, offset, width, height);
		System.out.println("\n");
		displayDigitalNumber(number2, offset, width, height);
	}

}