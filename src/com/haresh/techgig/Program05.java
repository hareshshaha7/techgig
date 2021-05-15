/**
 * 
 */
package com.haresh.techgig;

import java.util.Scanner;

/*
	Contest: Java To Salesforce Bootcamp Challenge  Results

	Who is smarter (50 Marks)
	Rahul and Rama are siblings. Rahul believes that he is smarter than Rama so Rama decides to teach him a lesson. 
	She gives him 2 non-negative integers A and B and asks him to reverse the two numbers and tell the greater one.
	
	If the numbers after reversing contain leading zeros, you have to ignore them. See the sample examples for better clarification.
	
	Input Format: The only line containing 2 non-negative integers A and B.
	
	Constraints: 0 <= A, B <= 1000, 000, 000
	
	Output Format: Print the answer to the problem.
	
	Sample TestCase 1
	Input: 12 100
	Output: 21
	Explanation: The numbers after reversing becomes 21 (12) and 1 (001). Clearly, 21 is bigger.
	
	Sample TestCase 2
	Input:100 100
	Output: 1
	Explanation: Both of the numbers after reversing become 1. So, 1 is the answer.
 */

/**
 * @author Haresh Shaha
 * @since 15-May-2021
 *
 */
public class Program05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number1 = sc.nextInt();
		int number2 = sc.nextInt();

		String reversedNumber1 = "";
		String reversedNumber2 = "";

		while (number1 != 0) {
			reversedNumber1 += number1 % 10;
			number1 = number1 / 10;
		}
		while (number2 != 0) {
			reversedNumber2 += number2 % 10;
			number2 = number2 / 10;
		}

		number1 = reversedNumber1 != "" ? Integer.parseInt(reversedNumber1) : 0;
		number2 = reversedNumber2 != "" ? Integer.parseInt(reversedNumber2) : 0;

		System.out.println(number1 > number2 ? number1 : number2);
		sc.close();

	}

}
