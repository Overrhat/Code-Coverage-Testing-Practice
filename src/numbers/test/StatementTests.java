package numbers.test;

import static org.junit.Assert.*;
import numbers.ArmstrongNumbers;
import org.junit.Test;
import java.util.Arrays;

/**
 * StatementTests.java is a class that contains tests for the ArmstrongNumbers class.
 * These test cases aim to achieve maximum statement coverage for the findArmstrongNumbers method.
 *
 * The following statements have been identified in ArmstrongNumbers.java:
 * 1. Variable initialization (Lines 12-13): Initialization of `numDigits`, `sumOfPowers`, `temp`, and other variables.
 * 2. For-loop statement (Line 15): Iteration from `i = 1` to `i < limit`.
 * 3. While-loop statement (Line 18): Iteration for processing each digit of the current number.
 * 4. If condition statement (Line 21): Condition that checks if the sum of powers equals the original number.
 * 5. Array insertion statement (Line 22): Adding the Armstrong number to the result array.
 * 6. Return statement (Line 26): Returning the final array of Armstrong numbers.
 * 
 * Limitations in Coverage:
 * - When the limit is less than or equal to 1, the for-loop does not execute, so the inner statements (while-loop, if condition) are not covered.
 * - To achieve full statement coverage, multiple cases are tested, including numbers with multiple digits, which trigger repeated executions of the while-loop.
 * 
 * Test Cases:
 * 1. `testLimitZero`: Tests the scenario where the limit is 0, ensuring that no Armstrong numbers are found.
 * 2. `testSingleDigitNumbers`: Tests single-digit numbers to verify that all single-digit Armstrong numbers are correctly identified.
 * 3. `testDoubleDigitNumbers`: Tests numbers up to 100, ensuring that numbers with more than one digit are processed and Armstrong numbers are correctly identified.
 *
 * When running StatementTests.java with the current test cases, we achieve 100% statement coverage.
 *
 * Author: Jeruh Kim
 * Year: 2024
 */
public class StatementTests {

    /**
     * This test case covers the scenario where the limit is set to 0.
     * 
     * Rationale:
     * When the limit is 0, the for-loop does not execute, and no Armstrong numbers are found.
     * This test ensures that the code correctly handles cases where the limit is too small for the loop to run.
     * 
     * Statements Covered: Variable initialization and return statement.
     */
    @Test
    public void testLimitZero() {
        int[] result = ArmstrongNumbers.findArmstrongNumbers(0);
        assertArrayEquals(new int[] {}, trimArray(result));
    }

    /**
     * This test case covers the scenario where the limit is set to 10.
     * 
     * Rationale:
     * The limit is set to 10, which ensures the for-loop runs through numbers 1 to 9.
     * All single-digit Armstrong numbers should be found and returned.
     * This test covers the execution of both the for-loop and the if condition for true outcomes.
     * 
     * Statements Covered:
     * - For-loop initialization and iteration.
     * - While-loop for extracting digits.
     * - If condition for identifying Armstrong numbers.
     * - Insertion of Armstrong numbers into the result array.
     */
    @Test
    public void testSingleDigitNumbers() {
        int[] result = ArmstrongNumbers.findArmstrongNumbers(10);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // All Armstrong numbers less than 10
        assertArrayEquals(expected, trimArray(result));
    }

    /**
     * This test case covers the scenario where the limit is set to 100.
     * 
     * Rationale:
     * By setting the limit to 100, we ensure that the for-loop processes numbers with more than one digit (double-digit numbers).
     * This test checks if the while-loop runs multiple times for multi-digit numbers and verifies that Armstrong numbers are correctly identified.
     * 
     * Statements Covered:
     * - For-loop for iterating through double-digit numbers.
     * - While-loop for extracting digits (multiple iterations).
     * - If condition for non-Armstrong numbers.
     * - Insertion into the result array.
     */
    @Test
    public void testDoubleDigitNumbers() {
        int[] result = ArmstrongNumbers.findArmstrongNumbers(100);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Armstrong numbers under 100 are all single digits
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
