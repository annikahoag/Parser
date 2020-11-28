import java.util.Scanner;

public class Parser {
	
	//instance variables 
	Scanner scn = new Scanner(System.in);
	
	//constructor
	public Parser() {
		
	}
	
	
	//check for equal sign 
	public boolean hasEqual(String s) {
		char chr = s.charAt(0);
		
		if ( chr == '='){
			return true;
		}else {
			return false;
		}
	}
	
	
	//check for negative number
	public boolean negNum(String s, int i) {
		char chr = s.charAt(i);
		
		if (chr == '-') {
			return true;
		}else {
			return false;
		}
	}
	
	
	//checks for division by 0
	public static double divZero (double num1, double num2) throws ArithmeticException {
		if (num2 != 0) {
			return num1 / num2;
		}else {
			throw new ArithmeticException();
		}
	}
	
	
	//asks the user if they want to run again
		public boolean runAgain() {
			
			try {
				int run;
				scn = new Scanner (System.in);
				
				System.out.println("\nWould you like to run again? Type 1 for yes and 2 for no.");
				run = scn.nextInt();
				
				if (run ==2) {
					System.out.println("Program is ending.");
					return false;
				}else if (run == 1) {
					System.out.println("Program is restarting.");
					return true;
				}else {
					throw new MyException("Invalid input. Program will run again.");
				}
			
			//checks for invalid characters like = and *
			}catch (java.util.InputMismatchException e) {
				System.out.println("Invalid input. Program is restarting");
				return true;
				
			//checks for numbers other than 1 or 2 
			}catch (MyException ex) {
				System.out.println(ex.getMessage());
				return true;
			}
			
	}
			
	


	
	
}
