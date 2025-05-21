package binary_search;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Math.round;


public class simple_binary_search {
    public static void main(String[] args) {
        System.out.println(
                search(new int[]{-1,0,2,4,6,8}, 4)
        );
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left + ((right - left) / 2);
            if(target > nums[mid]){
                left = mid+1;
            } else if(target < nums[mid]) {
                right = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}