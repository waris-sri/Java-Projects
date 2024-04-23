import java.util.Stack;

public class Bracket {
	static Stack<Object> getOrder (String input,int index) {
		Stack<Object> list = new Stack<>();
		String str = new String();
		int length = input.length();
		int open = 0;
		for (int i = index; i < length; i++) {
			if (input.charAt(i) == '(' && open == 0) {
				open++;
				list = getOrder(input, i + 1);
				str += input.charAt(i);	
			}
			else if (input.charAt(i) == '(' && open > 0) {
				open++;
				str += input.charAt(i);
			}
			else if (input.charAt(i) == ')') {
				open--;
				if (open < 0) {
					break;
				}
				else {
					str += input.charAt(i);
				}
			}
			else {
				str += input.charAt(i);			
			}
		}
		list.add(str);
		return list;
	}
}
