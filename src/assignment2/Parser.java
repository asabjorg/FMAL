package assignment2;

import java.util.Scanner;
import java.util.Stack;

import assignment2.Token.TokenCode;
import assignment2.Lexer; 

public class Parser {
	
	//útfæra stack
	Stack<TokenCode> stack = new Stack();
	
	
	Scanner sc = new Scanner(System.in);
	
	String input = sc.next();
	
	TokenCode nextToken; 
	
	public void parse(){
		
		nextToken = Lexer.nextToken();
		Statements();
	}
	//fyrsti Non-terminal 
	private void Statements() {
		
		Statement();
		nextToken = Lexer.nextToken();
		if(nextToken == TokenCode.SEMICOL){
			stack.push(nextToken);
			nextToken = Lexer.nextToken();
		}
		else{
			Error();
		}
		
		Statements();
		
		if(nextToken.equals(TokenCode.END)){
			stack.push(nextToken);
			nextToken = Lexer.nextToken();
		}
	}
	
	private void Statement(){
		
		
	}
	
	private void Error(){
		
		System.out.println("Syntax Error!");
		return; 
		
	}


	
	
	

	
	
	

}
