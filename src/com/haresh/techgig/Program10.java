package com.haresh.techgig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
	Ness Code Fest: Save the City (100 Marks)
	
	The City of Wonderland is under attack by an unknown virus. There are twenty six types of people who reside in the city of Wonderland 
	i.e every person in the city belongs to any one of the types from a - z.
	
	Many people have got infected by the virus and are fighting for their lives. Scientists have studied the virus and its impact on different types of people. 
	After their study, they found that the virus is unable to cause damage to any of the people who belong to the type which are maximum in the city.
	
	For example - If in the city, the maximum people belong to the type b, then all b types of people will be safe from the virus.
	
	Scientists want to know the type for which the people are maximum so that they can safeguard them and also develop vaccination as an antidote to the virus 
	which will provide immunity to other people. They are short of time and therefore need your help in determining the type for which the people are maximum in the city. 
	
	Note: If there are more than one type of people with equal maximum then the type with lesser ASCII value will be considered.
	
	Can you help the Scientists in saving the city ?
	
	Input Format:
		The first line of input consists of the number of test cases, T.
		Next T lines each consists of a string representing the type of each individual person in the city.
	
	Constraints:
		1<= T <=10
		1<= |string| <=100000
	
	Output Format:
		For each test case, print the required output in a separate line.
	
	Sample TestCase 1
	Input:
		2
		gqtrawq
		fnaxtyyzz
	
	Output:
		q
		y
	
	Explanation:
		Test Case 1: There are 2 q types of people rest all are present alone.
		Test Case 2: There are 2 y and 2 z types of people. Since the maximum value is same, the type with lesser Ascii value is considered as output. Therfore, y is the correct type.
 */

/**
 * @author Haresh Shaha
 * @since 27-Sep-2021
 *
 */
public class Program10 {

	/**
	 * @param args
	 */
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int testcases = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < testcases; i++) {
			Map<Character, Integer> countMap = new HashMap<>();

			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				int count = 0;
				if (countMap.containsKey(ch))
					count = countMap.get(ch);
				countMap.put(ch, count + 1);
			}
			char c = countMap.entrySet().stream().max((c1,
					c2) -> c1.getValue() == c2.getValue() ? c2.getKey() - c1.getKey() : c1.getValue() - c2.getValue())
					.get().getKey();
			System.out.println(c);
		}

		sc.close();
	}

}
