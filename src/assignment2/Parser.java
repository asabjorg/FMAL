package assignment2;

import java.util.Stack;

public class Parser {
	
	Token tokens;
	Lexer lexer; 
	Stack<String> stack;
	Token nextToken; 
	
	public Parser(Lexer myLexer) {
		this.lexer = myLexer;
		this.stack = new Stack<String>();
	}

	public void parse(){
		nextToken = Lexer.nextToken();
		Statements();
	}
	
	private void Statements() {
		
		if(nextToken.tCode.equals(Token.TokenCode.END)){
			return; 
		}
		else{
			Statement();
			if(nextToken.tCode == Token.TokenCode.SEMICOL){
				//poppa öllu af og skrifa út?? forlúppa
				nextToken = Lexer.nextToken();
				Statements();
			}
			else{
				Error();		
			}
		}			
	}
	
	private void Statement(){
		
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
			if(nextToken.tCode == Token.TokenCode.ID){
				nextToken = Lexer.nextToken();
			}
		}
		else{
			Error();
		}
	}

	private void Expr(){
		Term();
		if(nextToken.tCode == Token.TokenCode.ADD){
			stack.push("ADD");
			nextToken = Lexer.nextToken();
			Expr();
		}
		
		else if(nextToken.tCode == Token.TokenCode.SUB){
			stack.push("SUB");
			nextToken = Lexer.nextToken();
			Expr();
		}
	}
	
	private void Term(){
		Factor();
		if(nextToken.tCode == Token.TokenCode.MULT){
			stack.push("MULT");
			nextToken = Lexer.nextToken();
			Term();
		}
	}
	
	private void Factor(){
		
		if(nextToken.tCode == Token.TokenCode.INT){
			System.out.println("PUSH " + nextToken.lexeme);
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
