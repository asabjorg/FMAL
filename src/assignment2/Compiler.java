package assignment2;

import java.util.Scanner;

import assignment2.Lexer;
import assignment2.Token.TokenCode;

public class Compiler {
	
	
	public static void main(String[] args) {
		
		Token token; 
		
		//Lexer myLexer = new Lexer();
		//Parser myParser = new Parser(myLexer);
		token  = Lexer.nextToken();
		
		System.out.println(token.lexeme);
		System.out.println(token.tCode);

	}
}