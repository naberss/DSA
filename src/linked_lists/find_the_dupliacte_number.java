package linked_lists;


import java.util.Arrays;

public class find_the_dupliacte_number {
    public static void main(String[] args) {
        System.out.println(
                findDuplicate(
                        new int[]{1,2,5,4,3,5}
                )
        );
    }

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        // will never reach it here
        return -99999;
    }

}