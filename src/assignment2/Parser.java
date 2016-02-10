package assignment2;

import java.util.Scanner;
import java.util.Stack;

import assignment2.Token.TokenCode;
import assignment2.Lexer; 

public class Parser {
	
	Token tokens;
	Lexer lexer; 
	Stack<TokenCode> stack;
	TokenCode nextToken; 
	
	public Parser(Lexer myLexer) {
		this.lexer = myLexer;
		this.stack = new Stack<TokenCode>();
	}

	public void parse(){
		
		nextToken = Lexer.nextToken();
		Statements();
	}
	
	private void Statements() {
		
		Statement();
		nextToken = Lexer.nextToken();
		if(nextToken == TokenCode.SEMICOL){
			//fall sem prentar 
			//prenta það sem við á, 
			//láta interpreter taka við stdin frá parser
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
		
		if(nextToken == TokenCode.ID){
			nextToken = Lexer.nextToken();
			if(nextToken == TokenCode.ASSIGN){
				nextToken = Lexer.nextToken();
				Expr();
			}
			else{
				Error();
			}
		}
		else{
			Error();
		}
	}
	
	private void Error(){
		
		System.out.println("Syntax Error!");
		return; 
		
	}

	private void Expr(){
		
		
		
	}
	
	private void Term(){
		
		
		
	}
	
	private void Factor(){
		
		
		
	}
	
	private void Print(){
		
		//þegar ég fæ semikommu að prenta út það sem er á staknum m.v. það sem kemur af staknum. 
	}
	
	
	

	
	
	

}
