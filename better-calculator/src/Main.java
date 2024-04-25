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
 import bracket.Bracket;
 // TODO: Add PEMDAS sequence!
 
 public class Main {
     
     public static Double calc(String input) {
         // Prepare a string to hold the current [string] number.
         String numStr = new String();
         // Prepare array lists to hold the numbers and operations.
         ArrayList<Double> numbers = new ArrayList<>();
         ArrayList<String> operations  = new ArrayList<>();
         // Loop through the input string per character.
         for (int i = 0; i < input.length(); i++) {
             char currValue = input.charAt(i);
             // If the currValue is a number, add it to the number string.
             if (Character.isDigit(currValue)||currValue=='.') {
                 numStr += String.valueOf(currValue);            	
             }
             // Else if currValue is an operation, appropriately add the number
             // and operation to their array lists. Then reset the numStr string.
             else if (currValue == '+' || currValue == '*' || currValue == '/' || currValue == '-') {
            	 if(input.charAt(i+1) == '-' && currValue == '-') {
            		 operations.add(String.valueOf('+'));
            		 i++;
            	 }
            	 else if(input.charAt(i+1) == '-' && currValue == '+') {
            		 operations.add(String.valueOf('-'));
            		 i++;
            	 }
            	 else {            		 
            		 operations.add(String.valueOf(currValue));
            	 }
                 numbers.add(Double.parseDouble(numStr));
                 numStr = "";
             }
         }
         // Add the last number in the input string to the numbers array list.
         numbers.add(Double.parseDouble(numStr));
         
         // Loop through the operations array list and perform the correlating
         // operation on the numbers array list.
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
             case "*":
                 answer *= numbers.get(i + 1);
                 break;
             case "/":
                 answer /= numbers.get(i + 1);
                 break;
             default:
                 System.out.println("Operation not found!");
                 break;
             }
         }
         return answer;
     }
     public static Double calc(String input,Double ans) {
         // Prepare a string to hold the current [string] number.
    	 String numStr = new String();
    	 if(input.charAt(0)=='+'||input.charAt(0)=='-'||input.charAt(0)=='*'||input.charAt(0)=='/') {
    		numStr = String.valueOf(ans);
    	 }
         // Prepare array lists to hold the numbers and operations.
         ArrayList<Double> numbers = new ArrayList<>();
         ArrayList<String> operations  = new ArrayList<>();
         // Loop through the input string per character.
         for (int i = 0; i < input.length(); i++) {
             char currValue = input.charAt(i);
             // If the currValue is a number, add it to the number string.
             if (Character.isDigit(currValue)||currValue=='.') {
                 numStr += String.valueOf(currValue);            	
             }
             // Else if currValue is an operation, appropriately add the number
             // and operation to their array lists. Then reset the numStr string.
             else if (currValue == '+' || currValue == '*' || currValue == '/' || currValue == '-') {
            	 if(input.charAt(i+1) == '-' && currValue == '-') {
            		 operations.add(String.valueOf('+'));
            		 i++;
            	 }
            	 else if(input.charAt(i+1) == '-' && currValue == '+') {
            		 operations.add(String.valueOf('-'));
            		 i++;
            	 }
            	 else {            		 
            		 operations.add(String.valueOf(currValue));
            	 }
                 numbers.add(Double.parseDouble(numStr));
                 numStr = "";
             }
         }
         // Add the last number in the input string to the numbers array list.
         numbers.add(Double.parseDouble(numStr));
         
         // Loop through the operations array list and perform the correlating
         // operation on the numbers array list.
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
             case "*":
                 answer *= numbers.get(i + 1);
                 break;
             case "/":
                 answer /= numbers.get(i + 1);
                 break;
             default:
                 System.out.println("Operation not found!");
                 break;
             }
         }
         return answer;
     }
     
     static Double calcBrack(String input) {
    	 ArrayList<String> list = Bracket.getOrder(input);
    	 ArrayList<Double> Dlist = new ArrayList<Double>();
    	 for(int i = 0;i < list.size();i++) {
    		 String temp = list.get(i);
    		 for(int j = i-1;j>=0;j-- ) {
    			 temp = temp.replace('('+list.get(j)+')',Dlist.get(j).toString());
    		 }
    		 Dlist.add(calc(temp));
    	 }
    	 return Dlist.getLast();
     }
     static Double calcBrack(String input,Double ans) {
    	 ArrayList<String> list = Bracket.getOrder(input);
    	 ArrayList<Double> Dlist = new ArrayList<Double>();
    	 for(int i = 0;i < list.size();i++) {
    		 String temp = list.get(i);
    		 for(int j = i-1;j>=0;j-- ) {
    			 temp = temp.replace('('+list.get(j)+')',Dlist.get(j).toString());
    		 }
    		 Dlist.add(calc(temp,ans));
    	 }
    	 return Dlist.getLast();
     }
     
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        Double ans = calcBrack(input);
        System.out.print("="+ans);
        while(true) {
        	input = scn.nextLine();
            if(input.equals("X")) {
            	break;
            }
            ans = calcBrack(input,ans);
            System.out.print("="+ans);
        }
        scn.close();
     }
 }	
