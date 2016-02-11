package assignment2;

import java.util.Stack;

public class Parser {
	
	Token tokens;
	Lexer lexer; 
	Stack<Token.TokenCode> stack;
	Token nextToken; 
	
	public Parser(Lexer myLexer) {
		this.lexer = myLexer;
		this.stack = new Stack<Token.TokenCode>();
	}

	public void parse(){
		
		nextToken = Lexer.nextToken();
		Statements();
	}
	
	private void Statements() {
		System.out.println("Statements");
		Statement();
		nextToken = Lexer.nextToken();
		if(nextToken.tCode == Token.TokenCode.SEMICOL){
			nextToken = Lexer.nextToken();
			Statements();
		}
		else if(nextToken.tCode.equals(Token.TokenCode.END)){
			return;
		}
		else{
			System.out.println("This error: 1");
			Error();
		}
	}
	
	private void Statement(){
		
		System.out.println("Statement");
		if(nextToken.tCode == Token.TokenCode.ID){
			nextToken = Lexer.nextToken();
			if(nextToken.tCode == Token.TokenCode.ASSIGN){
				
				nextToken = Lexer.nextToken();
				Expr();
			}
			else{
				Error();
			}
		}
		else if(nextToken.tCode == Token.TokenCode.PRINT){
			nextToken = Lexer.nextToken();
			if(nextToken.tCode == Token.TokenCode.ASSIGN){
				nextToken = Lexer.nextToken();
			}
		}
		else{
			Error();
		}
	}

	private void Expr(){
		System.out.println("EXPR");
		Term();
		nextToken = Lexer.nextToken();
		if(nextToken.tCode == Token.TokenCode.ADD){
			nextToken = Lexer.nextToken();
			Expr();
		}
		
		else if(nextToken.tCode == Token.TokenCode.SUB){
			nextToken = Lexer.nextToken();
			Expr();
		}
	}
	
	private void Term(){
		System.out.println("TERM");
		Factor();
		if(nextToken.tCode == Token.TokenCode.MULT){
			nextToken = Lexer.nextToken();
			Term();
		}
	}
	
	private void Factor(){
		System.out.println("Factor");
		if(nextToken.tCode == Token.TokenCode.INT){
			nextToken = Lexer.nextToken();
		}
		else if(nextToken.tCode == Token.TokenCode.ID){
			nextToken = Lexer.nextToken();
		}
		else  if(nextToken.tCode == Token.TokenCode.LPAREN){
			Expr();
			if(nextToken.tCode == Token.TokenCode.RPAREN){
				nextToken = Lexer.nextToken();
			}
			else{
				Error();
			}
		}
		
	}
	
	private void Print(Token.TokenCode token){
		
		//þegar ég fæ semikommu að prenta út það sem er á staknum m.v. það sem kemur af staknum. 
	}
	
	private void Error(){
		
		System.out.println("Syntax Error!");
		return; 
		
	}


}
