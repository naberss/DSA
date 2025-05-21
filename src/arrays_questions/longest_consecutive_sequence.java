package arrays_questions;

import java.util.ArrayList;
import java.util.Arrays;

public class longest_consecutive_sequence {
    public static void main(String[] args) {
        //var t = longestConsecutive(new int[]{0,3,2,5,4,6,1,1}); -> 7
        //var t = longestConsecutive(new int[]{2,20,4,10,3,4,5}); -> 4
        var t = longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6});
        System.out.println("result: " + t);
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        var finalSequence = new ArrayList<Integer>();
        var counter = 1;
        var highestResult = 0;

        for (int i = 0; i < nums.length; i++){
            if(i != 0){
                if(nums[i-1] == nums[i]){
                    //continue;
                } else {
                    if((nums[i] - nums[i-1])==1){
                        counter++;
                    } else {
                        finalSequence.add(counter);
                        counter = 1;
                    }
                }
            }

            if(counter != 0 && (i == nums.length-1)){
                finalSequence.add(counter);
            }
        }

        for (Integer item: finalSequence){
            if (item > highestResult){
                highestResult = item;
            }
        }

        return highestResult;
    }



}