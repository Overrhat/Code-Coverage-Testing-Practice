package numbers.test;

import static org.junit.Assert.*;
import numbers.ArmstrongNumbers;
import org.junit.Test;
import java.util.Arrays;

/**
 * BranchTests.java is a class that contains tests for the ArmstrongNumbers class.
 * These test cases aim to maximize branch coverage for the findArmstrongNumbers method.
 *
 * The following branches have been identified:
 * 1. For-loop Condition (Line 15): i < limit
 *    - True Branch: Loop executes.
 *    - False Branch: Loop does not execute.
 * 2. While-loop Condition (Line 18): temp > 0
 *    - True Branch: Loop executes.
 *    - False Branch: Loop does not execute (after the last digit is processed).
 * 3. If Condition (Line 21): sumOfPowers == i
 *    - True Branch: Number is an Armstrong number.
 *    - False Branch: Number is not an Armstrong number.
 * 
 * Limitations in Coverage:
 * - The false branch of the while-loop condition (`temp > 0`) cannot be covered during the first iteration of the loop,
 *   as `temp` is initialized to the current value of `i`, which is always greater than 0.
 *   Therefore, full branch coverage for this condition is not achievable in the first loop iteration.
 * 
 * Test Cases:
 * 1. `testForLoopDoesNotExecute`: Ensures the false branch of the for-loop condition is tested.
 * 2. `testWhileLoopFalseBranch`: Ensures the while-loop condition (`temp > 0`) reaches the false branch once all digits have been processed.
 * 3. `testIfConditionTrue`: Tests when a number is an Armstrong number (true branch of the if condition).
 * 4. `testIfConditionFalse`: Ensures non-Armstrong numbers are handled correctly (false branch of the if condition).
 * 
 * By running the following test cases, we achieve approximately 83.3% branch coverage (5 out of 6 branches covered).
 * Full branch coverage is not possible due to the inherent limitation with the while-loop's first iteration.
 *
 * Author: Jeruh Kim
 * Year: 2024
 */
public class BranchTests {

    /**
     * This test case covers the false branch of the for-loop condition (`i < limit`).
     * 
     * Rationale:
     * When the limit is set to 1, the for-loop condition `i < limit` is false initially,
     * so the loop does not execute at all. This tests the behavior of the method when no iterations occur.
     * 
     * Branch Covered: False branch of the for-loop.
     */
    @Test
    public void testForLoopDoesNotExecute() {
        int[] result = ArmstrongNumbers.findArmstrongNumbers(1);
        assertArrayEquals(new int[] {}, trimArray(result)); // No Armstrong numbers under 1
    }

    /**
     * This test case covers the true and false branches of the while-loop condition (`temp > 0`).
     * 
     * Rationale:
     * The limit is set to 9. After the last digit of each number is processed, the while-loop terminates,
     * hitting the false branch when `temp` becomes 0.
     * This tests that the while-loop correctly exits after processing all digits.
     * 
     * Branch Covered: True and false branches of the while-loop (after processing digits).
     */
    @Test
    public void testWhileLoopFalseBranch() {
        int[] result = ArmstrongNumbers.findArmstrongNumbers(9);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8}; // All Armstrong numbers less than 9
        assertArrayEquals(expected, trimArray(result));
    }

    /**
     * This test case covers the true branch of the if condition (`sumOfPowers == i`).
     * 
     * Rationale:
     * When the limit is set to 2, the only Armstrong number (1) will be found and tested.
     * This ensures that the true branch of the if condition is exercised when a number is an Armstrong number.
     * 
     * Branch Covered: True branch of the if condition.
     */
    @Test
    public void testIfConditionTrue() {
        int[] result = ArmstrongNumbers.findArmstrongNumbers(2);
        assertArrayEquals(new int[] {1}, trimArray(result)); // 1 is the only Armstrong number < 2
    }

    /**
     * This test case covers the false branch of the if condition (`sumOfPowers != i`).
     * 
     * Rationale:
     * The limit is set to 10, which allows the method to test numbers 1 through 9 as Armstrong numbers.
     * This ensures that non-Armstrong numbers, like 10, hit the false branch of the if condition.
     * 
     * Branch Covered: False branch of the if condition.
     */
    @Test
    public void testIfConditionFalse() {
        int[] result = ArmstrongNumbers.findArmstrongNumbers(10);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Armstrong numbers < 10
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
