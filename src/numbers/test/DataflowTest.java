package numbers.test;

import static org.junit.Assert.*;
import numbers.ArmstrongNumbers;
import org.junit.Test;
import java.util.Arrays;

/**
 * DataflowTest.java is a class that contains a unique test case designed to improve the quality of the test suite
 * by focusing on a specific du-path that has not been covered by previous tests.
 * 
 * The variable we aim to test is the `numDigits` variable in the ArmstrongNumbers class.
 * 
 * The expectation for this test is that the `numDigits` variable should be correctly used to calculate 
 * whether each number's digits raised to the power of their count (numDigits) results in the original number.
 * 
 * This test improves the overall quality of the test suite as other tests do not sufficiently cover 
 * cases where numbers with more than three digits (which have a `numDigits` value greater than 3) are tested.
 * The test specifically checks if `numDigits` is correctly defined and used in the code.
 * 
 * Author: Jeruh Kim
 * Year: 2024
 */
public class DataflowTest {

    /**
     * This test case covers the du-path for the `numDigits` variable in the ArmstrongNumbers class.
     * 
     * The du-path for this test case is as follows:
     * 
     * Variable: numDigits
     * 
     * Definition: Line 16 - numDigits = String.valueOf(i).length();
     * The `numDigits` variable is defined when the number of digits in the current number `i` is calculated.
     * 
     * Use: Line 20 - sumOfPowers += Math.pow(digit, numDigits);
     * The `numDigits` variable is used to raise each digit of the number to the power of the number of digits.
     * 
     * Path: [16, 20] - The path starts when `numDigits` is defined and proceeds to its use when calculating the sum of digit powers.
     * 
     * Why This Path Was Not Previously Tested:
     * Previous tests focused on numbers with fewer digits (single-digit and double-digit numbers), 
     * so the path where `numDigits` takes a value greater than 3 was not exercised.
     * 
     * How This Test Improves the Test Suite:
     * This test ensures that `numDigits` is used correctly for numbers with four digits (such as Armstrong numbers 1634, 8208, 9474),
     * enhancing the robustness of the test suite by covering cases where `numDigits` takes on values greater than 3.
     */
    @Test
    public void testNumDigitsForFourDigitNumbers() {
        int[] result = ArmstrongNumbers.findArmstrongNumbers(10000);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474}; // Four-digit Armstrong numbers included

        assertArrayEquals(expected, trimArray(result));
    }

    /**
     * Trims the array to remove trailing zeros, ensuring that we only compare actual Armstrong numbers.
     *
     * @param array The array to be trimmed.
     * @return A new array without trailing zeros.
     */
    private int[] trimArray(int[] array) {
        int validLength = 0;
        for (int num : array) {
            if (num != 0) {
                validLength++;
            } else {
                break;
            }
        }
        return Arrays.copyOf(array, validLength);
    }
}
