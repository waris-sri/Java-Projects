import java.util.ArrayList;
import java.util.Stack;
public class Read {
	static ArrayList<Object> returnPriority(String input) {
		ArrayList<Object> list = new ArrayList<>();
		int length = input.length();
		String str = new String();
		int open = 1;
		for(int i =0 ; i < length ; i++ ) {
			if(input.charAt(i) == '(' ) {
				open++;
				str += input.charAt(i);	
				String inputNew = input.replace(str, "");
				list = returnPriority(inputNew);
				return list;
			}
			else if(input.charAt(i)==')' ) {
				open--;
				if(open != 0) {
					str += input.charAt(i);
				}
				else {
					str += input.charAt(i);
					break;
				}
			}
			else {
				str += input.charAt(i);				
			}
		}
		list.add(str);
		return list;
	}
	
	static ArrayList<Object> priority(String input) {
		ArrayList<Object> list = new ArrayList<>();
		int length = input.length();
		String str = new String();
		for(int i =0 ; i < length ; i++ ) {
			str += input.charAt(i);	
			if(input.charAt(i) == '(' ) {
				String inputNew = input.replace(str, "");
				list = returnPriority(inputNew);
				return list;
			}
		}
		list.add(str);
		return list;
	}
	
	static Stack<Object> test(String input,int index){
		Stack<Object> list = new Stack<>();
		String str = new String();
		int length = input.length();
		//int open = 0;
		for(int i =index ; i < length ; i++ ) {
			if(input.charAt(i)=='(') {
				//open++;
				list = test(input, i+1);
				list.add(str);
				return list;
			}
			if(input.charAt(i)==')') {
				list = test(input, i+1);
				list.add(str);
				return list;
			}
			else {
				str += input.charAt(i);			
			}
		}
		list.add(str);
		return list;
	}
}
