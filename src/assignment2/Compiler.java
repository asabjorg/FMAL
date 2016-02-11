package assignment2;

import java.io.FileNotFoundException;

import assignment2.Lexer;

public class Compiler {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
	
		Lexer myLexer = new Lexer();
		Parser myParser = new Parser(myLexer);
		myParser.parse();

	}
}