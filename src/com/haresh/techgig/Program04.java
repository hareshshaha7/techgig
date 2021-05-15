/**
 * 
 */
package com.haresh.techgig;

import java.util.Scanner;

/*
	Rupee Problem (100 Marks)
	In how many ways, can you pay N rupees with 1 rupee, 2 rupee & 5 rupee denominations, 
	in such a way that the number of 1 rupee coins are always greater than that of 2 rupee coins 
	and number of 2 rupee coins are always greater than that of 5 rupee coins.
	
	Note: At least one coin should be given from each denomination.
	
	Input Format
	The only line of input consists of a single integer, N, the amount in rupees.
	
	Constraints: 1 <= N <= 100
	
	Output Format
	Print the number of ways in which you can pay the amount as described.
	
	Sample TestCase 1
	Input: 10
	Output: 0
	Explanation: There is no way we can achieve this following the given conditions.
	
	Sample TestCase 2
	Input: 15
	Output: 2
	Explanation: Possible ways in which you can pay 15 rupees are (1 5rs, 2 2rs, 6 1rs) and (1 5rs, 3 2rps, 4 1rps).
	
	Logic:
			5 2 1
	1-11	-
	
	12		1 2 3	1	1 0+1
	
	13		1 2 4	1	2 0+1
	
	14		1 2 5	1	3 1+0
	
	15		1 2 6	2	4 1+1
			1 3 4
			
	16		1 2 7	2	5 1+1
			1 3 5
	
	17		1 2 8	2	6 2+0
			1 3 6
	
	18		1 2 9	3	7 2+1
			1 3 7
			1 4 5
	
	19		1 2 10	3	8 2+1
			1 3 8
			1 4 6
			
	20		1 2 11	4	9 3+0		1 0+1
			1 3 9
			1 4 7
			2 3 4
			
	21		1 2 12	5	10 3+1 		2 0+1
			1 3 10
			1 4 8
			1 5 6
			2 3 5
			
	22		1 2 13	5	11 3+1 		3 1+0
			1 3 11
			1 4 9
			1 5 7
			2 3 6
			
	23		1 2 14	6	12 4+0 		4 1+1
			1 3 12
			1 4 10
			1 5 8
			2 3 7
			2 4 6
			
	24		1 2 15	7	13 4+1		5 1+1
			1 3 13
			1 4 11
			1 5 9
			1 6 7
			2 3 8
			2 4 7
			
	25		1 2 16	7	14 4+1		6 2+0
			1 3 14
			1 4 12
			1 5 10
			1 6 8
			2 3 9
			2 4 8
			
	26		1 2 17	8	15 5+0		7 2+1
			1 3 15
			1 4 13
			1 5 11
			1 6 9
			2 3 10
			2 4 8
			2 5 6
			
	27		1 2 18	9	16 5+1		8 2+1
			1 3 16
			1 4 14
			1 5 12
			1 6 10
			1 7 8
			2 3 11
			2 4 10
			2 5 7
			
	28		1 2 19	10	17 5+1		9 3+0		1 0+1
			1 3 17
			1 4 15
			1 5 13
			1 6 11
			1 7 9
			2 3 12
			2 4 11
			3 2 9
			2 5 7
			
	29		1 2 20	11	18 6+0		10 3+1		2 0+1
			1 3 18
			1 4 16
			1 5 14
			1 6 12
			1 7 10
			2 3 13
			2 4 12
			2 5 9
			2 6 7
			3 2 10
			
	30		1 2 21	12	19 6+1 		11 3+1		3 1+0
			1 3 19
			1 4 17
			1 5 15
			1 6 13
			1 7 11
			1 8 9
			2 3 14
			2 4 13
			2 5 10
			2 6 8
			3 2 11
 */

/**
 * @author Haresh Shaha
 * @since 14-May-2021
 *
 */
public class Program04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		if (number < 12)
			System.out.println("0");
		else {
			number = number - 11;
			int ways = getWays(number) + getRemainingWays(number - 8);
			System.out.println(ways);
		}
		sc.close();
	}

	private static int getWays(int number) {
		return (number / 3) + (number % 3 == 0 ? 0 : 1);
	}

	private static int getRemainingWays(int number) {
		if (number < 0)
			return 0;

		return getWays(number) + getRemainingWays(number - 8);
	}

}
