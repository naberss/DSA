package stacks_questions;

public class minimum_stack {
    public static void main(String[] args) {
        System.out.println("starting");
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        minStack.getMin(); // return 0
        minStack.pop();
        minStack.top();    // return 2
        minStack.getMin(); // return 1
    }

}