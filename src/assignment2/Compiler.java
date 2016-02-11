package assignment2;

import java.io.FileNotFoundException;
import java.util.Scanner;

import assignment2.Lexer;
import assignment2.Token.TokenCode;

public class Compiler {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
	
		Lexer myLexer = new Lexer();
		Parser myParser = new Parser(myLexer);
		myParser.parse();

	}
}