/*
 * @author: Thanakrit S., Waris S.
 * @date: 24/4/2024
 * @description:
 * The program calculates the result of a mathematical expression by
 * converting the input string into an array list of numbers and operations,
 * such as "12 + 34 - 56 * 78 / 90", then performing the operations in
 * literal order from left to right(Prioritize brackets first).
 *
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import bracket.Bracket;

public class Main {
	public static Double calc(String input, Double ans) {
		// Prepare a string to hold the current [string] number.
		String numStr = new String();
		int w = 0;
		while (input.charAt(w) == ' ') {
			w++;
		}
		if (input.charAt(w) == '+' || input.charAt(w) == '-' || input.charAt(w) == '*' || input.charAt(w) == '/') {
			numStr = String.valueOf(ans);
		}
		// Prepare array lists to hold the numbers and operations.
		ArrayList<Double> numbers = new ArrayList<>();
		ArrayList<String> operations = new ArrayList<>();
		// Loop through the input string per character.
		for (int i = 0; i < input.length(); i++) {
			char currValue = input.charAt(i);
			// If the currValue is a number, add it to the number string.
			if (Character.isDigit(currValue) || currValue == '.') {
				numStr += String.valueOf(currValue);
			}
			// Else if currValue is an operation, appropriately add the number
			// and operation to their array lists. Then reset the numStr string.
			else if (currValue == '+' || currValue == '*' || currValue == '/' || currValue == '-') {
				w = i + 1;
				while (input.charAt(w) == ' ') {
					w++;
				}
				if (input.charAt(w) == '-' && currValue == '-') {
					operations.add(String.valueOf('+'));
					numbers.add(Double.parseDouble(numStr));
					numStr = "";
					i = w;
				} else if (input.charAt(w) == '-' && currValue == '+') {
					operations.add(String.valueOf('-'));
					numbers.add(Double.parseDouble(numStr));
					numStr = "";
					i = w;
				} else if (input.charAt(w) == '-' && currValue == '*') {
					operations.add(String.valueOf('*'));
					numbers.add(Double.parseDouble(numStr));
					numStr = "-";
					i = w;
				} else if (input.charAt(w) == '-' && currValue == '/') {
					operations.add(String.valueOf('-'));
					numbers.add(Double.parseDouble(numStr));
					numStr = "-";
					i = w;
				} else {
					operations.add(String.valueOf(currValue));
					numbers.add(Double.parseDouble(numStr));
					numStr = "";
				}
			}
		}
		// Add the last number in the input string to the numbers array list.
		numbers.add(Double.parseDouble(numStr));
		// Loop through the operations array list and perform
		// multiplication and division first
		int opeSize = operations.size();
		for (int i = 0; i < opeSize; i++) {
			Double temp;
			switch (operations.get(i)) {
				case "*":
					temp = numbers.get(i) * numbers.get(i + 1);
					operations.remove(i);
					numbers.set(i, temp);
					numbers.remove(i + 1);
					i--;
					opeSize = operations.size();
					break;
				case "/":
					temp = numbers.get(i) / numbers.get(i + 1);
					operations.remove(i);
					numbers.set(i, temp);
					numbers.remove(i + 1);
					i--;
					opeSize = operations.size();
					break;
				default:
					break;
			}
		}
		// Loop through the operations array list and perform the addition and
		// subtraction
		int numSize = numbers.size();
		Double answer = numbers.get(0);

		for (int i = 0; i < numSize - 1; i++) {
			switch (operations.get(i)) {
				case "+":
					answer += numbers.get(i + 1);
					break;
				case "-":
					answer -= numbers.get(i + 1);
					break;
				default:
					System.out.println("Operation not found!");
					break;
			}
		}
		return answer;
	}

	static Double calcBrack(String input, Double ans) {
		ArrayList<String> list = Bracket.getOrder(input);
		ArrayList<Double> Dlist = new ArrayList<Double>();
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			for (int j = i - 1; j >= 0; j--) {
				temp = temp.replace('(' + list.get(j) + ')', Dlist.get(j).toString());
			}
			Dlist.add(calc(temp, ans));
		}
		return Dlist.getLast();
	}

	static void calcStart() {
		try {
			Scanner scn = new Scanner(System.in);
			String input = scn.nextLine();
			Double ans = calcBrack(input, 0.0);
			System.out.println("= " + ans);
			while (true) {
				input = scn.nextLine();
				if (input.equals("X")) {
					break;
				}
				ans = calcBrack(input, ans);
				System.out.println("= " + ans);
			}
			scn.close();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Syntax error. Try again");
			calcStart();
		}
	}

	public static void main(String[] args) {
		// String input ="(1-2+(4 - 3 +( (5 + 7 )- (
		// 6*8-(18/9))))+(7-7+(5*6))-(1-2))/2"; (Test code)
		// 4*5-3+6/2*3+3+4-1*9-3/3 (Test code)
		calcStart();
	}
}