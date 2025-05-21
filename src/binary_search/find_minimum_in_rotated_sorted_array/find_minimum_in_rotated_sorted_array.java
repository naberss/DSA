package binary_search.find_minimum_in_rotated_sorted_array;

import java.util.Arrays;

public class find_minimum_in_rotated_sorted_array {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,6,1,2}));
        System.out.println(findMin(new int[]{4,5,0,1,2,3}));
        System.out.println(findMin(new int[]{4,5,6,7}));
        System.out.println(findMin(new int[]{1}));
        System.out.println(findMin(new int[]{2,1}));
        System.out.println(findMin(new int[]{5,1,2,3,4}));
        System.out.println(findMin(new int[]{2,3,4,5,1}));
        System.out.println(findMin(new int[]{2,3,4,5,6,1}));

    }

    public static int findMin(int[] nums) {

        var left = 0; //start index
        var right = nums.length-1; //end index
        var min = Integer.MAX_VALUE;


        while(left<=right){

            if(nums[left] > nums[right]){
                left++;
                min = Math.min(min,nums[right]);
            } else if (nums[left] < nums[right]){
                right--;
                min = Math.min(min,nums[left]);
            }

            int mid = left + ((right-left)/2);

            var predecessor = mid-1 >=0 && nums[mid-1]<nums[mid]?nums[mid-1]:Integer.MAX_VALUE;
            var successor = mid+1 <=nums.length-1 && nums[mid+1]<nums[mid]?nums[mid+1]:Integer.MAX_VALUE;


            if (predecessor>successor){
                left = mid+1;
                min = Math.min(min, nums[left]);
            } else if (successor>predecessor){
                right =mid-1;
                min = Math.min(min, nums[right]);
            } else {
                return nums[mid];
            }
        }

        return min;

    }

}