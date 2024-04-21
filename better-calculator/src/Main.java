/*
 * @author: Thanakrit S., Waris S.
 * @date: 20/4/2024
 * @description:
 * The program calculates the result of a mathematical expression by
 * converting the input string into an array list of numbers and operations,
 * such as "12 + 34 - 56 * 78 / 90", then performing the operations in
 * literal order from left to right.
 *
 */

 import java.util.Scanner;
 import java.util.ArrayList;
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
             if (Character.isDigit(currValue)) {
                 numStr += String.valueOf(currValue);            	
             }
             // Else if currValue is an operation, appropriately add the number
             // and operation to their array lists. Then reset the numStr string.
             else if (currValue == '+' || currValue == '*' || currValue == '/' || currValue == '-') {
                 operations.add(String.valueOf(currValue));
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
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         String input = scn.nextLine();
         System.out.println(calc(input));
         scn.close();
     }
 }	
