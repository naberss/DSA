package arrays_questions;

public class two_integer_sum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++ ){
            for(int j = 0; j < nums.length; j++ ){
                if(i!=j){
                    if(nums[i]+nums[j]==target){
                        return new int[]{i, j};
                    }
                }

            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }



}