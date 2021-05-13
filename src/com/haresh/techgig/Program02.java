/**
 * 
 */
package com.haresh.techgig;

import java.util.Scanner;

/**
 * @author Haresh Shaha
 * @since 09-Apr-2021
 *
 */
public class Program02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();

		for (int i = 0; i < testcases; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			int result = -1;
			if (num1 == num2) {
				result = 0;
			} else {
				int firstPrime = -1;
				int secondPrime = -1;

				for (int j = num1; j <= num2; j++) {
					if (isPrimeNumber(j)) {
						firstPrime = j;
						break;
					}
				}

				if (firstPrime != -1) {
					for (int j = num2; j >= firstPrime; j--) {
						if (isPrimeNumber(j)) {
							secondPrime = j;
							break;
						}
					}
				}

				if (secondPrime != -1) {
					result = secondPrime - firstPrime;
				}
			}

			System.out.println(result);
		}

		sc.close();
	}

	private static boolean isPrimeNumber(int number) {
		if (number == 2)
			return true;
		for (int i = 2; i <= (number + 1) / 2; i++) {
			if ((number % i) == 0)
				return false;
		}
		return true;
	}

}
