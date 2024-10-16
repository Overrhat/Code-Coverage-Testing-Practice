package numbers.test;

import static org.junit.Assert.*;
import numbers.ArmstrongNumbers;
import org.junit.Test;
import java.util.Arrays;

/**
 * EquivalenceTest.java is a class that contains tests for equivalence partitioning in the ArmstrongNumbers class.
 * These test cases are designed to test a specific equivalence class that has not been covered by previous tests.
 * 
 * The equivalence class we aim to test is for limits that are exactly equal to an Armstrong number.
 * 
 * The goal of these tests is to ensure that when the limit is exactly equal to an Armstrong number, 
 * the function correctly includes or excludes that Armstrong number based on the loop condition.
 * 
 * Equivalence Class Description:
 * - This equivalence class includes all limits where the `limit` is equal to an Armstrong number.
 * - It tests whether the function behaves correctly at the boundary where the limit is exactly an Armstrong number.
 * - According to the implementation, the loop runs from `i = 1` to `i < limit`, meaning the limit is exclusive.
 * 
 * These tests improve the overall quality of the test suite by checking boundary behavior, ensuring that 
 * Armstrong numbers at the exact limit are handled properly.
 * 
 * Author: Jeruh Kim
 * Year: 2024
 */
public class EquivalenceTest {

    /**
     * This test case covers the equivalence class where the limit is exactly equal to an Armstrong number (9474).
     * 
     * Equivalence Class: Limit is exactly equal to an Armstrong number.
     * 
     * Rationale:
     * In this test, the limit is set to 9474, which is an Armstrong number. According to the loop condition `i < limit`,
     * 9474 should not be included in the result since the limit is exclusive. This ensures that Armstrong numbers at the boundary
     * are not included when the limit is equal to the number.
     * 
     * Why This Class Was Not Previously Tested:
     * Previous tests did not specifically check the behavior of the method when the limit is set to an Armstrong number.
     * This test ensures that the function behaves correctly at this boundary.
     * 
     * How This Test Improves the Test Suite:
     * This test checks the edge case where the limit is equal to an Armstrong number, ensuring that the loop condition `i < limit`
     * excludes that number. This improves the robustness of the test suite by covering boundary conditions that might cause off-by-one errors.
     */
    @Test
    public void testLimitEqualToArmstrongNumber() {
        int limit = 9474;
        int[] result = ArmstrongNumbers.findArmstrongNumbers(limit);
        int[] expected = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208
            // 9474 is not included as per the loop condition (i < limit)
        };

        assertArrayEquals(expected, trimArray(result));
    }

    /**
     * This test case covers the equivalence class where the limit is one greater than an Armstrong number (9475).
     * 
     * Equivalence Class: Limit is slightly greater than an Armstrong number.
     * 
     * Rationale:
     * In this test, the limit is set to 9475, which is just above the Armstrong number 9474. Since the loop runs from `i = 1`
     * to `i < limit`, this test ensures that 9474 is correctly included in the result when the limit is greater than the Armstrong number.
     * 
     * Why This Class Was Not Previously Tested:
     * Previous tests did not specifically check the behavior of the method when the limit is just above an Armstrong number.
     * This tests the inclusion of the Armstrong number when the limit exceeds the number.
     * 
     * How This Test Improves the Test Suite:
     * This test ensures that Armstrong numbers are correctly included when the limit is slightly above an Armstrong number, 
     * improving the accuracy of the function at the boundary.
     */
    @Test
    public void testLimitOneMoreThanArmstrongNumber() {
        int limit = 9475;
        int[] result = ArmstrongNumbers.findArmstrongNumbers(limit);
        int[] expected = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474
            // 9474 is included because the limit is greater than 9474
        };

        assertArrayEquals(expected, trimArray(result));
    }

    /**
     * Trims the array to remove trailing zeroes, ensuring that we only compare actual Armstrong numbers.
     *
     * @param array The array to be trimmed.
     * @return A new array without trailing zeroes.
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
