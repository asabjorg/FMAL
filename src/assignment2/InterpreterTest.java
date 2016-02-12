package assignment2;
import java.util.Stack;
import java.util.Scanner;
//import java.io.*;
import java.util.*;


public class InterpreterTest {

	public static void main(String args[]){
		Stack<String> st = new Stack<>();

		int firstElement = 0;
		int secondElement = 0;
		int result = 0;
		String var;
		String pushResult;

		Scanner stdin = new Scanner(System.in);
		Map <String, Integer> map = new HashMap<String, Integer>();
		while (stdin.hasNextLine()) {
			String line = stdin.nextLine();

			String[] value = line.split("\\s");
			switch(value[0]){
			case "PUSH":
				String key = value[1];
				if(map.containsKey(key)){
					int valueFromMap = map.get(value[1]);
					String updateValue = "" + valueFromMap;
					st.push(updateValue);
				}
				else{
					st.push(value[1]);
				}
				break;
			case "ADD":
				if(st.empty()){
					System.out.printf("Error for operator: %s", line);
					System.exit(0);
				}
				firstElement = Integer.parseInt(st.pop());
				if(st.empty()){
					System.out.printf("Error for operator: %s", line);
					System.exit(0);
				}
				secondElement = Integer.parseInt(st.pop());
				result = firstElement + secondElement;
				pushResult = "" + result;
				st.push(pushResult);
				break;
			case "SUB":
				if(st.empty()){
					System.out.printf("Error for operator: %s", line);
					System.exit(0);
				}
				firstElement = Integer.parseInt(st.pop());
				if(st.empty()){
					System.out.printf("Error for operator: %s", line);
					System.exit(0);
				}
				secondElement = Integer.parseInt(st.pop());
				result = secondElement - firstElement;
				pushResult = "" + result;
				st.push(pushResult);
				break;
			case "MULT":
				if(st.empty()){
					System.out.printf("Error for operator: %s", line);
					System.exit(0);
				}
				firstElement = Integer.parseInt(st.pop());
				if(st.empty()){
					System.out.printf("Error for operator: %s", line);
					System.exit(0);
				}
				secondElement = Integer.parseInt(st.pop());
				result = firstElement * secondElement;
				pushResult = "" + result;
				st.push(pushResult);
				break;
			case "ASSIGN":
				if(st.empty()){
					System.out.printf("Error for operator: %s", line);
					System.exit(0);
				}
				firstElement = Integer.parseInt(st.pop());
				if(st.empty()){
					System.out.printf("Error for operator: %s", line);
					System.exit(0);
				}
				String test = st.pop();
				map.put(test, firstElement);
				break;
			case "PRINT":
				if(st.empty()){
					System.out.printf("Error for operator: %s", line);
					System.exit(0);
				}
				var = st.pop();
				System.out.println(var);
				break;
			default: 
				String[] Error = line.split("\\s");
				System.out.printf("Error for operator: %s ", Error[0]);
				System.exit(0);
			}
		}
	}
}
