package stacks_questions;

import java.util.Arrays;
import java.util.Stack;


public class car_fleet {
    public static void main(String[] args) {
        System.out.println(
                carFleet(10, new int[]{6,8}, new int[]{3,2})
        );
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        
        var pairs = new double[position.length][2];
        for (int i = 0; i < position.length; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = (double) (target - position[i]) /speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Double.compare(b[0],a[0]));

        var stack = new Stack<Double>();

        for(double[] p:pairs){
            stack.push(p[1]);
            if(
                    stack.size()>=2
                            && stack.peek() <= stack.get(stack.size()-2)
            ){
                stack.pop();
            }
        }


        return stack.size();
    }

}