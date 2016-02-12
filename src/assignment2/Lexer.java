package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import assignment2.Token.TokenCode;

public class Lexer {
	
	private Scanner sc;
	static char[] input;
	static int index;
	static Token token; 

	
	public Lexer() throws FileNotFoundException{
	
		index = 0; 
		String nextInput = "";
		sc = new Scanner(new File ("C:\\input.txt"));
	
		
		while(sc.hasNextLine()){
			nextInput += sc.nextLine();
		}
		input = nextInput.toCharArray();
	}
	
	public static Token nextToken() {
		
		Token token = new Token(); 
		
		while(input[index] == ' '){
			index++;
		}

		token = findLex();
		index++;
		
		return token;		
	}
	
	private static Token findLex(){
		
		//Búum til token til að skila
		Token token = new Token(); 
		
		//buum til streng til að matcha
		String lexeme = "" + input[index];
		
		if(lexeme.equals("(")){
			token.tCode  = TokenCode.LPAREN;
			token.lexeme = lexeme; 
			return token; 
		}
		else if(lexeme.equals(")")){
			token.tCode  = TokenCode.RPAREN;
			token.lexeme = lexeme; 
			return token; 
		}
		else if(lexeme.equals("+")){
			token.tCode  = TokenCode.ADD;
			token.lexeme = lexeme; 
			return token;
		}
		else if(lexeme.equals("=")){
			token.tCode  = TokenCode.ASSIGN;
			token.lexeme = lexeme; 
			return token;
		}
		else if(lexeme.equals("*")){
			token.tCode  = TokenCode.MULT;
			token.lexeme = lexeme; 
			return token;
		}
		else if(lexeme.equals(";")){
			token.tCode  = TokenCode.SEMICOL;
			token.lexeme = lexeme; 
			return token;
		}
		else if(lexeme.equals("-")){
			token.tCode  = TokenCode.SUB;
			token.lexeme = lexeme; 
			return token;
		}
		
		else if(Character.isAlphabetic(lexeme.charAt(0))){
		
			while((index + 1) < input.length && Character.isAlphabetic(input[index + 1]) ){
				index++;
				lexeme = lexeme + input[index];
			}
			
			//athuga frátekin orð
			if(lexeme.equals("print")){
				token.tCode  = Token.TokenCode.PRINT;
				token.lexeme = lexeme;
				return token; 
			}
			else if(lexeme.equals("end")){
				token.tCode  = Token.TokenCode.END;
				token.lexeme = lexeme;
				return token; 
			}
			//annars ID eða nafn á breytu
			else {
				token.tCode  = TokenCode.ID;
				token.lexeme = lexeme;
				return token; 
			}
			
		}
		else if(Character.isDigit(lexeme.charAt(0))){
			
			while(Character.isDigit(input[index + 1]) && input.length > index+1){
				index++;
				lexeme += input[index];
			}
			token.lexeme = lexeme; 
			token.tCode = Token.TokenCode.INT;
		}
		else{
			token.lexeme = "";
			token.tCode = TokenCode.ERROR;
		}
	
		
		return token; 
	}

	
	public static boolean isAlpha(String string) {
	    return string.matches("[a-zA-Z]+");
	}
	
	public static boolean isInt(String string) {
	    return string.matches("[0-9]+");
	}


}


