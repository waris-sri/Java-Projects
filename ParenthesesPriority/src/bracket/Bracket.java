package bracket;

import java.util.ArrayList;

public class Bracket {

	private static ArrayList<String> getOrderRecursion(String input, int index, ArrayList<String> list) {
		// Stack<Object> list = new Stack<>(); // Prepare a stack to store the order of
		// the brackets
		String str = new String(); // Prepare a string to store the order of the brackets
		int length = input.length(); // Prepare a variable to store the length of the input string
		int open = 0; // Initiate a variable to store the number of open brackets
		for (int i = index; i < length; i++) {
			if (input.charAt(i) == '(' && open == 0) {
				open++; // Add the first open bracket to the stack
				list = getOrderRecursion(input, i + 1, list); // Get order of brackets in substring after the first open
																// bracket
				str += input.charAt(i); // Add the first open bracket order to the string
			} else if (input.charAt(i) == '(' && open > 0) {
				open++; // Add the next open bracket to the stack
				str += input.charAt(i); // Add the next open bracket order to the string
			} else if (input.charAt(i) == ')') {
				open--;
				if (open < 0)
					break; // If the number of open brackets is negative, break the loop
				else
					str += input.charAt(i); // Else add the closing bracket order to the string
			} else
				str += input.charAt(i); // Else add the closing bracket order to the string
		}
		list.add(str);
		return list;
	}

	public static ArrayList<String> getOrder(String input) {
		ArrayList<String> list = new ArrayList<>(); // Prepare a stack to store the order of the brackets
		return getOrderRecursion(input, 0, list); // Pile 'list' upon 'input' (results)
	}
}