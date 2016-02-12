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
				Print();
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
			System.out.println("PUSH " + nextToken.lexeme);
			nextToken = Lexer.nextToken();
			if(nextToken.tCode == Token.TokenCode.ASSIGN){
				stack.push("ASSIGN");
				nextToken = Lexer.nextToken();
				Expr();
			}
			else{
				Error();
			}
		}
		else if(nextToken.tCode == Token.TokenCode.PRINT){
			stack.push("PRINT");
			nextToken = Lexer.nextToken();
			if(nextToken.tCode == Token.TokenCode.ID){
				System.out.println("PUSH " + nextToken.lexeme);
				nextToken = Lexer.nextToken();
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
		if(nextToken.tCode == Token.TokenCode.ADD){
			
			nextToken = Lexer.nextToken();
			if(stack.peek() == "MULT"){
				String pop = stack.pop();
				System.out.println(pop);
			}
			stack.push("ADD");
			Expr();
		}
		
		else if(nextToken.tCode == Token.TokenCode.SUB){
			if(stack.peek() == "MULT"){
				String pop = stack.pop();
				System.out.println(pop);
			}
		
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
			System.out.println("PUSH " + nextToken.lexeme);
			nextToken = Lexer.nextToken();
		}
		else  if(nextToken.tCode == Token.TokenCode.LPAREN){
			stack.push("(");
			nextToken = Lexer.nextToken();
			Expr();
			if(nextToken.tCode == Token.TokenCode.RPAREN){
					
				while(stack.peek() != "("){
					String pop = stack.pop();
					System.out.println(pop);	
				}		
				stack.pop();
				
				nextToken = Lexer.nextToken();
			}
			else{
				Error();
			}
		}
		else{
			Error();
		}
		
	}
	
	private void Print(){
		
		while(!stack.empty()){
			String pop = stack.pop();
			System.out.println(pop);
		}
	}
	
	private void Error(){
		
		System.out.println("Syntax Error!");
		return; 
		
	}


}
