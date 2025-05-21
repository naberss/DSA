package arrays_questions;

import java.util.Arrays;

public class products_of_array_discluding_self {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        productExceptSelf(new int[]{1,2,4,6})
                )
        );
    }

    public static int[] productExceptSelf(int[] nums) {
        var finaList = new int[nums.length];

        if(nums.length==0){return nums;}

        for(int i = 0; i < nums.length; i++){

            int finalProduct = 1;
            for(int j = 0; j < nums.length; j++){
                if(i!=j){
                    finalProduct = finalProduct * nums[j];
                }
            }
            finaList[i]=finalProduct;

        }
        return finaList;
    }
}