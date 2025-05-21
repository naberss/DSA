package two_pointers;

import java.util.Arrays;


public class two_sum_II_input_array_Is_sorted {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3))
        );
    }

    public static int[] twoSum(int[] numbers, int target) {
        int L = 0;
        int R = numbers.length - 1;

        while (L < R) {
            int sum = numbers[L] + numbers[R];
            if (sum > target) {
                R--;
            } else if (sum < target) {
                L++;
            } else {
                break;
            }
        }
        return new int[]{(L + 1), (R + 1)};
    }

}