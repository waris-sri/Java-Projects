/*
 * @author: Thanakrit S., Waris S.
 * @date: 18/4/2024
 * @description:
 * Each time you start, you'll need to enter how many digits you want your integers to have.
 * Then the game will generate a random number from 0 to the number you chose.
 * To win, you need to guess what the numbers are by entering your answer into the terminal.
 * Every time you guess, the game will tell you how many numbers are in the correct position.
 * Try to guess the number with the least number of guesses possible!
 * Note: The digits are free of duplicates.
 * 
 */

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

// TODO: Optimize the code
// TODO: Add a way to save the scores

public class Main {
	public static void main(String[]args) {
		ArrayList<Integer> integer = new ArrayList<>();
		ArrayList<Integer> score = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		String input = new String();
		Random randGen = new Random();
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		boolean cheat = false;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US);
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss").withLocale(Locale.US);
		
		// for indexing digits in guesses
		for (int i = 0; i < 10; i++) {
			integer.add(i, i);
		}
		
		while (true) {
			System.out.println("+———————————————————————————————————————+");
			System.out.println("|        \033[32;1mWelcome to Shitty Wordle!\033[0m      |");
			System.out.println("| Enter \033[33m<START>\033[0m to play                 |");
			System.out.println("| Enter \033[33m<RULES>\033[0m to view the rules       |");
			System.out.println("| Enter \033[33m<SCORE>\033[0m to view all your scores |");
			System.out.println("| Enter \033[33m<CLOSE>\033[0m to exit                 |");
			System.out.println("| Enter \033[33m<CHEAT>\033[0m to enable/disable cheat |");
			System.out.println("+———————————————————————————————————————+");
			input = sc.nextLine().toLowerCase();
			switch (input) {
				case "start":
					ArrayList<String> anslist = new ArrayList<String>();
					ArrayList<Integer> integerC = new ArrayList<>(integer);
					//System.out.println(integerC);
					//System.out.println(integer);
					System.out.println("\033[33;1m\nHow many digits would you like your integer to have (up to 10)?\033[0m");
					int digit = scInt.nextInt();
					while (digit > 10 || digit < 1) {
						System.out.println("\033[31;1mThe number that you have entered either exceeded 10, was negative, or was 0.\nPlease try again.\033[0m");
						digit = scInt.nextInt();
					}
					for (int i = 0; i < digit; i++) {
						//System.out.print("digit — i = ");
						//System.out.println(digit—i);
						int test = randGen.nextInt(digit-i);
						//System.out.println("test = "+test);
						int num = integerC.get(test);
						anslist.add(String.valueOf(num));
						integerC.remove(test);
					}
					String answer = new String();
					String randNum = new String();
					for (int i = 0; i < digit; i++) {
						randNum = randNum + anslist.get(i);
					}
					int guess = 0;
					while (true) {
						if (cheat == true) {
							System.out.println("\033[36;3mCHEAT: The answer is " + randNum + ".\033[0m");
						}
						System.out.println("\033[33m\nEnter your guess (must be a " + digit + "-digit integer):\nEnter <G> to give up.\033[0m");
						answer = sc.nextLine();
						// System.out.println("You entered " + answer); // might not need this
						if (answer.equals("G")) {
							break;
						}
						if (answer.length() == randNum.length() && answer.equals(randNum)) {
							System.out.println("\033[32;1mThere are " + digit + " correct number(s).\033[0m\n");
							guess++;
							break;
						}
						else if (answer.length() == randNum.length()) {
							int correctNum = 0;
							for (int i = 0; i < randNum.length(); i++) {
								if (answer.charAt(i) == randNum.charAt(i)) {
									correctNum++;
								}
							}
							System.out.println("\033[32;1mCorrect guesses: " + correctNum + "\033[0m\n");
							guess++;
						}
						else {
							System.out.println("\033[31;1mInvalid guess, try again!\033[0m\n");
						}
					}
					if (answer.equals("G")) {
						System.out.println("\033[35;1mYou gave up. The answer was " + randNum + ".\033[0m");
						/* for (int i = 0; i < 40; i++) {
							System.out.print("——");
						}
						*/ System.out.println();
					}
					else {
						System.out.println("\033[35;1mCongratulations! It took you " + guess + " guesses to win.\033[0m");
						score.add(guess);
						Collections.sort(score); 
						list.add(score.indexOf(guess), dateFormatter.format(LocalDate.now()) + " | " + timeFormatter.format(LocalTime.now()) + " | Answer: " + randNum + "\t| Cheat: " + cheat);
						/* for (int i = 0; i < 40; i++) {
							System.out.print("——");
						}
						*/ System.out.println();
					}
					break;
				
				case "rules":
					System.out.println("\033[3m\nEach time you start, you'll need to enter how many digits you want your integers to have. \nThen the game will generate a random number from 0 to the number you chose. \nTo win, you need to guess what the numbers are by entering your answer into the terminal. \nEvery time you guess, the game will tell you how many numbers are in the correct position. \nTry to guess the number with the least number of guesses possible! \nNote: The digits are free of duplicates.\033[0m");
					/* for (int i = 0; i < 40; i++) {
						System.out.print("——");
					}
					*/ System.out.println();
					break;
				
				case "score":
					if (list.isEmpty()) {
						System.out.println("\033[96;3mNo score was recorded.\033[0m");
						/* for (int i = 0; i < 40; i++) {
							System.out.print("——");
						}
						*/ System.out.println();
					}
					else {
						for (int i = 0; i < score.size(); i++) {
							System.out.println(i + 1 + ") " + score.get(i) + " guesses \033[0m| " + list.get(i));
						}
						/* for (int i = 0; i < 40; i++) {
							System.out.print("——");
						}
						*/ System.out.println();
					}
					break;
				
				case "close":
					System.out.println("\033[35;1mThank you for playing!\033[0m");
					/* for (int i = 0 ; i < 40; i++) {
						System.out.print("——");
					} */
					break;
				
				case "cheat":
					if (cheat == true) {
						cheat = false;
						System.out.println("\033[96;3mCheat disabled\033[0m");
					}
					else {
						cheat = true;
						System.out.println("\033[96;3mCheat enabled\033[0m");
					}
					/* for (int i = 0 ; i < 40; i++) {
						System.out.print("——");
					} */
					System.out.println();
					break;
				
				default:
					System.out.println("\033[31;1mInvalid input, try again!\033[0m\n");
					// for (int i = 0 ; i < 40; i++) {
					// 	System.out.print("——");
					// }
					System.out.println();
					break;
			}
			if (input.equals("close")) {
				break;
			}
		}
		sc.close();
		scInt.close();
	}
}