package com.haresh.techgig;

import java.util.Scanner;

public class Program01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String virus = sc.nextLine();
		int numberOfPeople = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < numberOfPeople; i++) {
			String bloodComposion = sc.nextLine();
			String testResult = "POSITIVE";
			int startIndex = 0;

			for (int j = 0; j < bloodComposion.length(); j++) {
				int index = virus.substring(startIndex).indexOf(bloodComposion.charAt(j));

				if (startIndex > virus.length() || index == -1) {
					System.out.println(j + ": " + bloodComposion.charAt(j));
					testResult = "NEGATIVE";
					break;
				}

				startIndex += index;
			}

			System.out.println(testResult);
		}

		sc.close();
	}

}
