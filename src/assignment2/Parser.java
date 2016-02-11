/*package assignment2;

import java.util.Stack;

import assignment2.Token.TokenCode;
import assignment2.Lexer; 

public class Parser {
	
	Token tokens;
	Lexer lexer; 
	Stack<TokenCode> stack;
	Token nextToken; 
	
	public Parser(Lexer myLexer) {
		this.lexer = myLexer;
		this.stack = new Stack<TokenCode>();
	}

	public void parse(){
		
		nextToken = Lexer.nextToken();
		Statements();
	}
	/*
	private void Statements() {
		
		Statement();
		nextToken = Lexer.nextToken();
		if(nextToken == TokenCode.SEMICOL){
			
			nextToken = Lexer.nextToken();
		}
		else{
			Error();
		}
		
		Statements();
		
		if(nextToken.equals(TokenCode.END)){
			
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

	private void Expr(){
		
		Term();
		nextToken = Lexer.nextToken();
		if(nextToken == TokenCode.ADD){
			nextToken = Lexer.nextToken();
			Expr();
		}
		
		else if(nextToken == TokenCode.SUB){
			nextToken = Lexer.nextToken();
			Expr();
		}
	}
	
	private void Term(){
	
		Factor();
		if(nextToken == TokenCode.MULT){
			nextToken = Lexer.nextToken();
			Term();
		}
	}
	
	private void Factor(){
		if(nextToken == TokenCode.INT){
			nextToken = Lexer.nextToken();
		}
		else if(nextToken == TokenCode.ID){
			nextToken = Lexer.nextToken();
		}
		else  if(nextToken == TokenCode.LPAREN){
			Expr();
			if(nextToken == TokenCode.RPAREN){
			nextToken = Lexer.nextToken();
			}
			else{
				Error();
			}
		}
		
		
	}
	
	private void Print(TokenCode token){
		
		//þegar ég fæ semikommu að prenta út það sem er á staknum m.v. það sem kemur af staknum. 
	}
	
	private void Error(){
		
		System.out.println("Syntax Error!");
		return; 
		
	}*/
	
	
	

	
	
	

}
