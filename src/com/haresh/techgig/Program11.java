/**
 * 
 */
package com.haresh.techgig;

import java.util.Scanner;

/*
	TCS Hiring Contest: Number pairs (100 Marks) [NOT SOLVED]
	
	Rajiv has been playing around with very big numbers. He keeps calculating the sum of digits of various numbers and compares them. 
	But now he is tired and wants you to do the job for him.
	You have to tell the total pairs of number (a,b) where 0 <= (a,b) <= N such that sum of digits of a is less than that of b . 
	Since the number of such pairs could be huge.Output it modulo 10^9+7.
	
	Input Format: The First line of input contains an Integer N.
	
	Constraints: 1 <= N <= 10^50
	
	Output Format: You must print an Integer denoting the answer to the problem modulo 10^9+7.
	
	Sample TestCase 1
		Input: 3
		Output: 6
		Explanation: Total such pairs are (0,1) ,(0,2),(0,3) ,(1,2) ,(1,3) (2,3).
 */

/**
 * @author Haresh Shaha
 * @since 27-Sep-2021
 *
 */
public class Program11 {

	/**
	 * @param args
	 */
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		double number = sc.nextDouble();
		double result = 0;

		for (int i = 0; i <= number; i++) {
			result += getSum(i, number);
			// System.out.println(i +" : "+getSum(i, number));
		}

		System.out.println((int) (result % (Math.pow(10, 9) + 7)));
		sc.close();
	}

	public static double getSum(double n, double num) {
		double result = 0;
		if (n == 0)
			return num;
		while (n > 0) {
			result += num - n;
			n = n - 9;
		}
		return result;
	}
}
