/**
 * 
 */
package com.haresh.techgig;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
	Contest: Java To Salesforce Bootcamp Challenge
	
	Save the City (50 Marks)
	The City of Wonderland is under attack by an unknown virus. There are twenty six types of people who reside in the city of Wonderland 
	i.e every person in the city belongs to any one of the types from a - z.
	
	Many people have got infected by the virus and are fighting for their lives. Scientists have studied the virus and its impact on different types of people. 
	After their study, they found that the virus is unable to cause damage to any of the people who belong to the type which are maximum in the city.
	
	For example - If in the city, the maximum people belong to the type b, then all b types of people will be safe from the virus.
	
	Scientists want to know the type for which the people are maximum so that they can safeguard them and also develop vaccination as an antidote to the virus which will provide immunity to other people. They are short of time and therefore need your help in determining the type for which the people are maximum in the city. 
	
	Note: If there are more than one type of people with equal maximum then the type with lesser ASCII value will be considered.
	
	Can you help the Scientists in saving the city ?
	
	Input Format
		The first line of input consists of the number of test cases, T.
		Next T lines each consists of a string representing the type of each individual person in the city.
	
	Constraints
		1<= T <=10
		1<= |string| <=100000
	
	Output Format
		For each test case, print the required output in a separate line.
	
	Sample TestCase 1
	Input
		2
		gqtrawq
		fnaxtyyzz
	Output
		q
		y
	Explanation
		Test Case 1: There are 2 q types of people rest all are present alone.
		Test Case 2: There are 2 y and 2 z types of people. Since the maximum value is same, the type with lesser Ascii value is considered as output. Therfore, y is the correct type.
 */

/**
 * @author Haresh Shaha
 * @since 15-May-2021
 *
 */
public class Program06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testcases = sc.nextInt();
		Map<String, Integer> typeCount = null;
		sc.nextLine();

		for (int i = 0; i < testcases; i++) {
			typeCount = new HashMap<>();

			String people = sc.nextLine();

			for (int j = 0; j < people.length(); j++) {
				String person = String.valueOf(people.charAt(i));
				typeCount.put(person, typeCount.getOrDefault(person, 0) + 1);
			}

			Collection<Integer> values = typeCount.values();
			String safeType = typeCount.entrySet().stream().filter(entry -> entry.getValue() == Collections.max(values))
					.map(entry -> entry.getKey()).findFirst().get();
			System.out.println(safeType);
		}

		sc.close();

	}

}
