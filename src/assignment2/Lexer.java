package assignment2;

import assignment2.Token.TokenCode;

public class Lexer {

	public static TokenCode nextToken(String input){
	
		if(input.equals("{")){
			return TokenCode.LPAREN;
		}
		else if(input.equals("}")){
			return TokenCode.RPAREN;
		}
		else if(input.equals("+")){
			return TokenCode.ADD;
		}
		else if(input.equals("=")){
			return TokenCode.ASSIGN;
		}
		else if(input.equals("*")){
			return TokenCode.MULT;
		}
		else if(input.equals(";")){
			return TokenCode.SEMICOL;
		}
		else if(input.equals("-")){
			return TokenCode.SUB;
		}
		else if(input.equals(";")){
			return TokenCode.SUB;
		}
		else if(input.equals("end")){
			return TokenCode.END;
		}
		else if(input.equals("print")){
			return TokenCode.PRINT;
		}
		else if(isInt(input)){
			return TokenCode.INT;
		}
		else if(isAlpha(input)){
			return TokenCode.ID;
		}
			
		return TokenCode.ERROR;
		
	}
	
	public static boolean isInt(String input) {
	    return input.matches("[0-9]+");
	}
		
	public static boolean isAlpha(String input) {
	    return input.matches("[A-Za-z]+");
	}
	

}
