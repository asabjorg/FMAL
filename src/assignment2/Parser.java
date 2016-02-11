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
		
		Statement();
		nextToken = Lexer.nextToken();
		if(nextToken.tCode == Token.TokenCode.SEMICOL){
			
			nextToken = Lexer.nextToken();
		}
		else{
			Error();
		}
		
		Statements();
		
		if(nextToken.tCode.equals(Token.TokenCode.END)){
			
			if(Lexer.nextToken() != null){
				Error();
			}
			else{
				return;
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
		else{
			Error();
		}
	}

	private void Expr(){
		
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
	
		Factor();
		if(nextToken.tCode == Token.TokenCode.MULT){
			nextToken = Lexer.nextToken();
			Term();
		}
	}
	
	private void Factor(){
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
		
		//�egar �g f� semikommu a� prenta �t �a� sem er � staknum m.v. �a� sem kemur af staknum. 
	}
	
	private void Error(){
		
		System.out.println("Syntax Error!");
		return; 
		
	}


}
