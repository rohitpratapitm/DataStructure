package com.sikar.string.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class NumberToWords {

	private static final Map<Integer, String> wordMap = new HashMap<>();
	private final StringBuilder result = new StringBuilder();
	private static final String SPACE = " ";
	private static final String AND = "and";

	public NumberToWords() {

		wordMap.put(1, "");
		wordMap.put(1, "One");
		wordMap.put(2, "Two");
		wordMap.put(3, "Three");
		wordMap.put(4, "Four");
		wordMap.put(5, "Five");
		wordMap.put(6, "Six");
		wordMap.put(7, "Seven");
		wordMap.put(8, "Eight");
		wordMap.put(9, "Nine");
		wordMap.put(10, "Ten");
		wordMap.put(11, "Eleven");
		wordMap.put(12, "Twelve");
		wordMap.put(13, "Thirteen");
		wordMap.put(14, "Fourteen");
		wordMap.put(15, "Fifteen");
		wordMap.put(16, "Sixteen");
		wordMap.put(17, "Seventeen");
		wordMap.put(18, "Eighteen");
		wordMap.put(19, "Nineteen");
		wordMap.put(20, "Twenty");
		wordMap.put(30, "Thirty");
		wordMap.put(40, "Fourty");
		wordMap.put(50, "Fifty");
		wordMap.put(60, "Sixty");
		wordMap.put(70, "Seventy");
		wordMap.put(80, "Eighty");
		wordMap.put(90, "Ninety");
		wordMap.put(100, "Hundred");
		wordMap.put(1000, "Thousand");
	}

	public static void main(String[] args) {
		// code
		// Note that size of arr[] is considered 100 according to
		// the constraints mentioned in problem statement.
		int[] arr = new int[100];

		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		// One by one run for all input test cases
		while (t > 0) {
			// Input the size of the array
			int n = sc.nextInt();
			NumberToWords gfg = new NumberToWords();
			gfg.numberToWords(n);
			// Compute and print result
			System.out.println(gfg.result);

			t--;
		}
	}

	public void numberToWords(int n) {

		int rem = 0;
		int[] position = new int[4];
		int index = 0;
		
		if(wordMap.containsKey(n)){
			result.append(wordMap.get(n));
			return;
		}
		while (n > 0) {

			int digit = n % 10;
			position[index++] = digit;
			n = n / 10;
		}
		// One digit number
		if (index == 1) {
			getUnitDigit(position[index - 1]);
		}
		// Two digit number
		else if (index == 2) {
			getTensDigit(position);
		}
		// Three digit number
		else if (index == 3) {
			getHundredsDigit(position);
		} else if(index == 4){
			getThousandDigit(position);
			// throw new Exception("Number too big");
		}
	}

	public void getUnitDigit(int number) {
		result.append(wordMap.get(number));
	}

	public void getTensDigit(int[] number) {
		// get digit at 10's place
		if(number [1] == 1){
			result.append(wordMap.get(number[1]*10+number[0]*1));
			return;
		}
		result.append(wordMap.get(number[1] * 10));
		result.append(SPACE);
		// get Unit Digit
		getUnitDigit(number[0]);
	}

	public void getHundredsDigit(int[] number) {
		// get digit at 100's place
		result.append(wordMap.get(number[2]));
		result.append(SPACE);
		result.append(wordMap.get(100));
		result.append(SPACE);
		result.append(AND);
		result.append(SPACE);
		// get Two Digit
		getTensDigit(number);
	}
	
	public void getThousandDigit(int[] number) {
		// get digit at 10's place
		getUnitDigit(number[3]);
		result.append(SPACE);
		result.append(wordMap.get(1000));
		result.append(SPACE);
		
		getHundredsDigit(number);
	}
}
