package assignment2;

import java.util.Scanner;

import assignment2.Lexer;
import assignment2.Token.TokenCode;

public class Compiler {
	
	
	public static void main(String[] args) {
		System.out.println("Write: ");
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
	
		
		
		if(Lexer.nextToken(input) == TokenCode.MULT){

			System.out.println("Multi");
		}
		else{
			
			System.out.println("Not working");
		}
		
		
		
		/*Lexer myLexer = new Lexer();
		Parser myParser = new Parser(myLexer);
		myParser.parse();*/

	}

}
