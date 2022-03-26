package com.haresh.techgig;

/*
    Prize Challenge by Times Internet ltd - Microservices
 */

import java.util.Scanner;

/**
 * @author Haresh Shaha
 * @since 26-Mar-2022
 *
 */
public class Program12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numPackets = sc.nextInt();
        int[] balls = new int[numPackets];
        int maxBalls = 0;
        for (int i=0; i<numPackets; i++) {
            balls[i] = sc.nextInt();
            maxBalls = Math.max(maxBalls, balls[i]);
        }

        int[] dp = new int[maxBalls+1];
        dp[1] = 1;
        for (int i=2; i<=maxBalls; i++) {
            int n = getDependant(i);
            if (i==n)
                dp[i] = i+1;
            else
                dp[i] = dp[n]+i;
        }

        int totalSteps = 0;
        for (int i=0; i<numPackets; i++) {
            System.out.println(dp[balls[i]]);
            totalSteps+=dp[balls[i]];
        }
        System.out.println(totalSteps);
    }

    private static int getDependant(int num) {
        if (num < 4)
            return num;

        for (int i=num/2; i>=2; i--) {
            if (num%i == 0)
                return i;
        }
        return num;
    }
}
