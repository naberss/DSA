package arrays_questions;

import java.util.Arrays;

public class duplicated_integer {

    public static void main(String[] args) {

    }

    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (j != i) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}