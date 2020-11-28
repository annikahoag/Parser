import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner scn = new Scanner(System.in);
		Parser parse = new Parser();
		String myStr;
		String str;
		boolean hasEqual;
		boolean isNeg;
		char arithType=0;
		double dNum1 = 0, dNum2 = 0;
		double result;
		boolean runAgain = true;
		
		while (runAgain == true) {
			String sNum1 = "", sNum2 = "";
		
			//input the string
			System.out.println("\nPlease enter an equation. \n"
					+ "Your equation must start with an equal sign and "
					+ "must only contain numbers and arithmetic operators.");
			myStr = scn.nextLine();
			
			
			//deletes all white spaces 
			str = myStr.replaceAll("\\s", "");
			
			//check for equal sign
			hasEqual = parse.hasEqual(str);
			
			
			if (hasEqual) {
				
				//loop through string
				for (int i = 1; i < str.length(); i++) {
					if (i == 1) {
						
						//checks for negative sign
						isNeg = parse.negNum(str, 1);
						if (isNeg) {
							sNum1 = sNum1 + '-';
							continue;
						}
					}
					//checks for arithmetic operator, make first num
					if (str.charAt(i) != '+' && str.charAt(i) != '-'
							&& str.charAt(i) != '*' && str.charAt(i) != '/') {
						sNum1 = sNum1 + str.charAt(i);
						
					}else {
						//assign arithmetic type 
						arithType = str.charAt(i);
						
						//make second num
						for (int j = i+1; j < str.length(); j++) {
								sNum2 = sNum2 + str.charAt(j);

						}
					
						break;
					}//end of else	
				}//end of for loop
			
				
				//error handling
				try {
					dNum1 = Double.valueOf(sNum1);
					dNum2 = Double.valueOf(sNum2);
					
					
					//print results
					switch (arithType) {
						case '+':
							result = dNum1 + dNum2;
							System.out.println(result);
							break;
						case '-':
							result = dNum1 - dNum2;
							System.out.println(result);
							break;
						case '*':
							result = dNum1 * dNum2;
							System.out.println(result);
							break;
						case '/':
							result = parse.divZero(dNum1, dNum2);
							System.out.println(result);
							break;
							
					}
					
				//division by 0	
				}catch (ArithmeticException e){
					System.out.println("Arithmetic error. Can not divide by 0.");
				
				//invalid input 
				}catch (NumberFormatException e) {
					System.out.println("Invalid input. Please only enter numbers");
				}
				
			
				
				
			}else {
				//catches equal sign
				try {
					throw new MyException("Error. \n" + str);
				}
				catch (MyException ex) {
					System.out.println(ex.getMessage());
				}
				
				
			}//end of else
		
			
			runAgain = parse.runAgain();
		
		}//end of while
	}

}
