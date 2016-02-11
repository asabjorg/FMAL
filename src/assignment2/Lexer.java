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

		token.lexeme = findLex().lexeme;
		System.out.println(token.lexeme);
		token.tCode = findLex().tCode; 
		System.out.println(token.tCode);
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

			int length = lexeme.length();
			
			while(isAlpha(lexeme) && length > index+1){
				index++;
				lexeme += input[index];
			}
			//athuga frátekin orð
			if(lexeme.equals("print")){
				token.tCode  = TokenCode.PRINT;
				token.lexeme = lexeme;
				return token; 
			}
			else if(lexeme.equals("end")){
				token.tCode  = TokenCode.END;
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
			
		int lenght = lexeme.length(); 
			
			while(isInt(lexeme) && lenght > index+1){
				index++;
				lexeme += input[index];
				
			}
		}
		else{
			token.lexeme = "";
			token.tCode = TokenCode.ERROR;
			index++;
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


