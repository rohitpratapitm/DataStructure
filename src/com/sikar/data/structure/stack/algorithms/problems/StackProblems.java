package com.sikar.data.structure.stack.algorithms.problems;

import java.util.Stack;

public class StackProblems {

	
	public void reverseString(String inputString){
		
		Stack<Character> stack = new Stack<Character>();
		
		char[] input = inputString.toCharArray();
		
		for(Character c:input){
			
			stack.push(c);
		}
		
		for(int i=0; !stack.isEmpty();i++){
			
			input[i] = stack.pop();
		}
		
		System.out.println(input);
	}
	
	public void reveresStringWithoutStack(String inputString){
		
		char[] inputArray = inputString.toCharArray();
		
		for(int i=0,k=inputArray.length-1;i<k;i++,k--){
			
			char temp = inputArray[k];
			inputArray[k] = inputArray[i];
			inputArray[i] = temp;
		}
		
		System.out.println(inputArray);
	}
	
	/**
	 * [{(a+b) * (b-c)}]
	 * 
	 * @param expression
	 */
	public boolean checkForBalancedParenthesis(String expression){
		
		Stack<Character> stack = new Stack<Character>();
		
		char[] inputArray = expression.toCharArray();
		
		for(Character c:inputArray){
			
			if(c == '[' || c == '{' || c == '('){
				
				stack.push(c);
			}
			else if(c == ']' || c == '}' || c == ')'){
				
				if(stack.isEmpty() || !matchesPair(stack.peek(),c)){
					
					return false;
				}
				else{
					stack.pop();
				}
			}
		}
		
		return (stack.size() == 0 ? true : false);
	}
	
	private boolean matchesPair(Character peek, Character c) {
		
		if((c == ')' && peek == '(') ||(c == '}' && peek == '{') || (c == ']' && peek == '[')){
			return true;
		}
		
		return false;
	}
	
	//For post fix, evaluate from left to right
	public char evaluatePostfixExpression(String expression){
		
		Stack<Character>stack = new Stack<>();
		
		char[] inputArray = expression.toCharArray();
		
		for(Character c : inputArray){
			
			if(isOperand(c)){
				stack.push(c);
			}
			if(isOperator(c)){
				
				char operandOne = stack.pop();
				char operandTwo = stack.pop();
				
				char result = (char)perform(c,operandOne,operandTwo);
				
				stack.push(result);
			}
		}
		return stack.pop();
	}

	private int perform(Character c, char operandOne, char operandTwo) {

		int result = 0;
		
		if(c == '+'){
			result = Integer.parseInt(""+operandOne) + Integer.parseInt(""+operandTwo);
		}
		else if(c == '-'){
			
			result = Integer.parseInt(""+operandOne) - Integer.parseInt(""+operandTwo);
		}
		else if(c == '*'){
			
			result = Integer.parseInt(""+operandOne) * Integer.parseInt(""+operandTwo);
		}
		else{
			result = Integer.parseInt(""+operandOne) / Integer.parseInt(""+operandTwo);
		}
		return result;
	}

	private boolean isOperator(Character c) {
		
		if(c == '+' || c == '*' || c == '-' || c == '/'){
			return true;
		}
		return false;
	}

	private boolean isOperand(Character c) {
		
		try{
			Integer.parseInt(""+c);
			
		}catch(NumberFormatException e){
			return false;
		}
		
		return true;
	}


	public Stack<Integer> sortStackUsingStack(Stack<Integer> stack) {

		if (stack == null || stack.empty()) {
			return stack;
		}

		Stack<Integer> otherStack = new Stack<>();

		while (!stack.empty()) {

			Integer element = stack.pop();

			if (otherStack.empty()) {
				otherStack.push(element);
				continue;
			}
			Integer existingItem = otherStack.peek();

			if (element >= existingItem) {
				// then just push
				otherStack.push(element);
			} else {
				// pop the existing element
				existingItem = otherStack.pop();
				// push the new element
				otherStack.push(element);
				// push back the existingItem
				otherStack.push(existingItem);
			}
		}
		return otherStack;
	}

	public static void main(String args[]){
		
		StackProblems tools = new StackProblems();
		
//		tools.reverseString("Rohit");
//		
//		tools.reveresStringWithoutStack("tihoR");
//		
//		System.out.println(tools.checkForBalancedParenthesis("[{(a+b * (b-c)}]"));
//		
//		System.out.println(tools.evaluatePostfixExpression("23*54*+9-"));
//		
		Stack<Integer> stack = new Stack<>();
		stack.push(10);stack.push(7);stack.push(12);stack.push(2);
		
		Stack<Integer> otherStack = tools.sortStackUsingStack(stack);
		System.out.println(otherStack);
	}
}
