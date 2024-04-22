import java.util.ArrayList;
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
			}
		}
		list.add(str);
		return list;
	}
}
