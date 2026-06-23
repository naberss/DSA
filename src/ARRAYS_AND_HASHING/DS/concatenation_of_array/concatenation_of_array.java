package ARRAYS_AND_HASHING.DS.concatenation_of_array;

import java.util.Arrays;

public class concatenation_of_array {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(getConcatenation(new int[]{1,4,1,2}))
        );
    }

    public static int[] getConcatenation(int[] nums) {

        var numsSize = nums.length;
        var ans = new int[numsSize*2];

        for(int i=0;
            i<ans.length;
            i++){


            if(i>=numsSize){
                ans[i]=nums[i-numsSize];
            } else {
                ans[i]=nums[i];
            }

        }
        return ans;
    }
}
