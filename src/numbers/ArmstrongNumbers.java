package numbers;

public class ArmstrongNumbers {	
	/**
	 * Finds all Armstrong numbers up to a specified limit.
	 * An Armstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
	 * 
	 * The method iterates through all numbers from 1 to the specified limit, checks if each number is an Armstrong number, 
	 * and stores it in an array if it is.
	 * 
	 * @param limit The upper limit up to which Armstrong numbers are to be found.
	 * @return An array containing all Armstrong numbers less than the specified limit. 	          
	 */
	public static int[] findArmstrongNumbers(int limit) {
	    int numDigits;                                           
	    int sumOfPowers;                                        
	    int number;                                             
	    int temp;                                               
	    int[] armstrongNumbers = new int[limit];                
	    int count = 0;                                        

	    for (int i = 1; i < limit; i++) {                      
	        numDigits = String.valueOf(i).length();             
	        sumOfPowers = 0;                                   
	        temp = i;                                          
	        while (temp > 0) {                                
	            int digit = temp % 10;                        
	            sumOfPowers += Math.pow(digit, numDigits);    
	            temp /= 10;                                   
	        }
	        if (sumOfPowers == i) {                           
	            armstrongNumbers[count] = i;                  
	            count++;                                      
	        }			
	    }

	    return armstrongNumbers;                              
	}
}
