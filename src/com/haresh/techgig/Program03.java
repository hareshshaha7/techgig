/**
 * 
 */
package com.haresh.techgig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/*
	Distinct Words (100 Marks)
	Given a string(word), S, print the number of distinct words with or without meaning that can be formed with the letters of the given word.
	
	Note: Each word should start with a consonant.
	
	Input Format
	The only line of input consists of a string, S
	
	Constraints: 1<= |S| <=20
	
	Output Format
	Print the number of distinct words in a separate line.
	
	Sample TestCase 1
	Input: CAT
	Output: 4
	Explanation: CAT, CTA, TAC, TCA. (ACT, ATC are not valid words, as they start with vowel letter)
	
	Sample TestCase 2
	Input: BOB
	Output: 2
	Explanation: BOB and BBO are two words.
	
	Sample TestCase 3
	Input: CHAIR
	Output: 72
	
	Logic:
	a 0
	
	b 1
	
	bc 2x1 2
	
	ab 1x1 1
	
	abc 2x2x1 4
	
	aab 1x2x1/2x1 1 
	
	aeb 1x2x1 1 bae bea 
	
	abb 2x2x1/2x1 2 bba bab
	
	aabb 2x3x2x1/2x1x2x1 3 bbaa baba baab
	
	aeb 1x2x1 2 bae bea

	So, Formula is: (allowed chars i.e. non wowels)!/repetation char! (char with more than 1 occurance)
*/

/**
 * @author Haresh Shaha
 * @since 14-May-2021
 *
 */
public class Program03 {
	public static void main(String args[]) throws Exception {

		// Write code here
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Map<Character, Integer> charOccarance = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			charOccarance.put(ch, charOccarance.getOrDefault(ch, 0) + 1);

		}

		long totalChars = str.length();

		Predicate<Character> consonants = (ch) -> !ch.equals('a') && !ch.equals('e') && !ch.equals('i')
				&& !ch.equals('0') && !ch.equals('u') && !ch.equals('A') && !ch.equals('E') && !ch.equals('I')
				&& !ch.equals('O') && !ch.equals('U');
		long numerator = charOccarance.keySet().stream().filter(consonants)
				.map((ch) -> Long.valueOf(charOccarance.get(ch))).collect(Collectors.summingLong(Long::longValue));

		while (--totalChars > 1) {
			numerator = numerator * totalChars;
		}

		Predicate<Character> multipleChars = (ch) -> charOccarance.get(ch) > 1;
		Long denominator = charOccarance.keySet().stream().filter(multipleChars)
				.map((ch) -> Long.valueOf(charOccarance.get(ch)))
				.map((Function<? super Long, ? extends Long>) (Long n) -> LongStream.rangeClosed(1, n).reduce(1,
						(long a, long b) -> a * b))
				.collect(Collectors.summingLong(Long::longValue));

		boolean val = Long.valueOf(denominator) != 0;
		long b = val ? Long.valueOf(denominator) : 1;
		long a = numerator / b;

		System.out.println(a);

		sc.close();
	}
}
