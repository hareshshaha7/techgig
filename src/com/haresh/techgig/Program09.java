/**
 * 
 */
package com.haresh.techgig;

import java.util.Scanner;

/*
	Tribes (100 Marks)
	
	In a remote island, there lives three tribes - The Rock Tribe, The Scissor Tribe and The Paper Tribe.
	
	If two individuals of different tribes meet (probability of meeting is equal for all tribes) then the tribe of one person can kill the person belonging to other tribe according to following rules:
		1. Rock tribe people can kill people of Scissor tribe.
		2. Scissor tribe people can kill people of Paper tribe.
		3. Paper tribe people can kill people of Rock tribe.
	
	Your task is to determine for each tribe, what is the probability that this tribe will be the only one to inhabit this island after a long enough period of time?
	
	Input Format
		First line will contain three integers r, s and p, denoting the person of Rock, Scissor and Paper tribe respectively.
	
	Constraints
		1 <= r, s, p <= 100
	
	Output Format
		Print three space separated real numbers, denoting the probabilities, at which the Rock Tribe, the scissor Tribe and the Paper Tribe will be the only surviving tribes, respectively.
	
	Round off your answer up to 5 digits after decimal.
	
	Sample TestCase 1
		Input: 3 3 3
		Output: 0.33333 0.33333 0.33333
 */

/**
 * @author Haresh Shaha
 * @since 08-Jul-2021
 *
 */
public class Program09 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rockTribe = sc.nextInt();
		int scissorTribe = sc.nextInt();
		int paperTribe = sc.nextInt();

		double[][][] dp = new double[101][101][101];

		for (int r = rockTribe; r >= 0; --r) {
			for (int s = scissorTribe; s >= 0; --s) {
				for (int p = paperTribe; p >= 0; --p) {
					if ((r == 0 && s == 0) || (s == 0 && p == 0) || (r == 0 && p == 0))
						continue;
					double totalWays = r * s + s * p + p * r;
					if (r > 0)
						dp[r - 1][s][p] += dp[r][s][p] * (r * p / totalWays);
					if (s > 0)
						dp[r][s - 1][p] += dp[r][s][p] * (r * s / totalWays);
					if (p > 0)
						dp[r][s][p - 1] += dp[r][s][p] * (s * p / totalWays);
				}
			}
		}

		double rockTribeWinningPercentage = 0, scissorTribeWinningPercentage = 0, paperTribeWinningPercentage = 0;
		for (int i = 1; i <= rockTribe; i++) {
			rockTribeWinningPercentage += dp[i][0][0];
		}
		for (int i = 1; i <= scissorTribe; i++) {
			scissorTribeWinningPercentage += dp[0][i][0];
		}
		for (int i = 1; i <= paperTribe; i++) {
			paperTribeWinningPercentage += dp[0][0][i];
		}

		System.out.printf("%.5f %.5f %.5f", rockTribeWinningPercentage, scissorTribeWinningPercentage,
				paperTribeWinningPercentage);

		sc.close();
	}

}
