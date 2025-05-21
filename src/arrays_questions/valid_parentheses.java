package arrays_questions;

import java.util.HashMap;
import java.util.Stack;

public class valid_parentheses {
    public static void main(String[] args) {
        System.out.println(isValid("]]"));
    }

    public static boolean isValid(String s) {
        var openElementsStack = new Stack<String>();
        var closeToOpen = new HashMap<String, String>();
        closeToOpen.put(")","(");
        closeToOpen.put("}","{");
        closeToOpen.put("]","[");

        for (String ch: s.split("")){

            // if element is an opening bracket
            if(!closeToOpen.containsKey(ch)){
                openElementsStack.push(ch);
            } else {
                // else here means element is a closing bracket
                if(!openElementsStack.isEmpty() && openElementsStack.peek().equals(closeToOpen.get(ch))){
                    openElementsStack.pop();
                } else {
                    return false;
                }
            }
        }

        return openElementsStack.isEmpty();
    }

}