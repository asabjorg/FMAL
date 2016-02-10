package assignment2;

import assignment2.Token.TokenCode;

public class Lexer {

	public static TokenCode nextToken(String input){
		
		System.out.println(input);
		
		if(input.equals("{")){
			return TokenCode.LPAREN;
		}
		
		else if(input.equals("}")){
			return TokenCode.RPAREN;
		}
		
		else if(input.equals("+")){
			return TokenCode.ADD;
		}
		
		else if(input.equals("*")){
			return TokenCode.MULT;
		}
		else if(input.equals(";")){
			return TokenCode.SEMICOL;
		}
	
		return TokenCode.ERROR;
		
		
	}
	

}
