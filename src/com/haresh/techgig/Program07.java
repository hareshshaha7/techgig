/**
 * 
 */
package com.haresh.techgig;

import java.util.Arrays;
import java.util.Scanner;

/*
	Market (100 Marks)
	Today is Sunday and Disha is out for the shopping. She has reached to the famous market of the city. 
	She has a list of items which she wants to buy but she has a very low amount of cash today and no shop accepts any online payment method in the market. 
	Disha has only D rupees with her and wants to buy N items (she wants to buy as many units of item as possible). 
	She wants to shop in a way such that first she buy 1 quantity of all the items she wants to buy and then she will move to buy 2nd quantity of any item.
	
	Can you help her by calculating how many items she can buy today if she shops optimally?
	You are given an array which represents the price of items Disha wants to buy.
	
	Example :-
	If she wants to buy 4 items having price 4, 6, 2, 5 respectively and has 49 rupees only then she will buy in this order:- 1st item, 2nd item, 3rd item, 4th item (It will cost 17 rupees). Again she will buy in this order 1st, 2nd, 3rd, 4th (it will cost 17 rupees). Now, she has remaining 15 rupees so she can buy any 3 items.
	
	Input Format
		The first line of input consists of two space-separated integers, N (number of items Disha wants to buy) and D (amount of cash Disha has with her).
		The second line of input consists of N space-separated integers which represents the price of the N items Disha wants to buy.
	
	Constraints
		1<= N <=1e9
		1<= Ni <=10^15 (1e15)
		1<= D <=10^18 (1e18)
	
	Output Format
		Print the count of items which Disha can buy.
	
	Sample TestCase 1
	Input:
		5 24
		4 8 9 7 2
	Output:
		4
 */

/**
 * @author Haresh Shaha
 * @since 20-May-2021
 *
 */
public class Program07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int itemCount = sc.nextInt();
		int cash = sc.nextInt();
		int[] items = new int[itemCount];

		for (int i = 0; i < itemCount; i++) {
			items[i] = sc.nextInt();
		}

		int totalItemsCanBuy = getTotalItemsCanBuy(items, cash);
		System.out.println(totalItemsCanBuy);

		sc.close();
	}

	private static int getTotalItemsCanBuy(int[] items, int cash) {
		int totalItemsCanBuy = 0;
		int sum = Arrays.stream(items).sum();

		if (cash >= sum) {
			totalItemsCanBuy = (cash / sum) * items.length;
			cash = cash - ((cash / sum) * sum);
		}

		Arrays.sort(items);

		for (int i = 0; i < items.length; i++) {

			if (cash - items[i] < 0) {
				if (i == 0 || (totalItemsCanBuy / items.length) < 1)
					break;
				i = -1;
			} else {
				cash = cash - items[i];
				++totalItemsCanBuy;
			}
		}

		return totalItemsCanBuy;
	}

}
