package arrays_questions;

import java.util.HashMap;
import java.util.Stack;

public class evaluate_reverse_polish_notation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }

    public static int evalRPN(String[] tokens) {
        var length = tokens.length;
        var stack = new Stack<Integer>();

        var isOperator = new HashMap<String, Boolean>();
        isOperator.put("+", true);
        isOperator.put("-", true);
        isOperator.put("/", true);
        isOperator.put("*", true);

        // a valid rpn would never have only one element though
        if(length==1){
            return Integer.parseInt(tokens[0]);
        }

        for(int i = 0; i <tokens.length; i++){
            var currentToken = tokens[i];
            if(!isOperator.containsKey(currentToken)){
                stack.push(Integer.parseInt(currentToken));
            } else {
                var secondOperand = stack.pop();
                var firstOperand = stack.pop();
                stack.push(calculate(firstOperand, secondOperand, currentToken));
            }
        }

        // there should be only one last item on the stack
        return stack.pop();
    }

    private static int calculate(int operand1, int operand2, String operator) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                yield operand1 / operand2;
            }
            case "*" -> operand1 * operand2;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}