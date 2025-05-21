package stacks_questions;

import java.util.Arrays;
import java.util.Stack;


public class daily_temperatures {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        dailyTemperatures(new int[]{30,38,30,36,35,40,28})
                )
        );
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            var stack = new Stack<Integer>();

            for(int j=i;j<temperatures.length;j++){
                stack.push(temperatures[j]);
                if(stack.size()>=2 && stack.peek()> stack.getFirst()){
                    stack.pop();
                    result[i] = stack.size();
                    break;
                }
            }
        }

        return result;
    }

}