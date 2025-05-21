package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class three_sum {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new List[]{threeSum(new int[]{3,0,-2,-1,1,2})})
        );
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        var result = new HashSet<ArrayList<Integer>>();
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            //static element loop
            var L = (i==0?1:0);
            var R = nums.length-1;
            while(L<R){
                var sum = nums[i] + nums[L] + nums[R];

                if (sum == 0
                        && i!=L
                        && i!=R){
                    var tempList = new ArrayList<Integer>(){};
                    tempList.add(nums[i]);
                    tempList.add(nums[L]);
                    tempList.add(nums[R]);
                    tempList.sort(Integer::compareTo);
                    result.add(tempList);
                    R--;
                    L++;
                } else if (sum>0){
                    if(R==i){ R = R-2;} else{ R--;}
                } else if (sum < 0){
                    if(L==i){L = L+2;} else {L++;}
                } else {
                    break;
                }
            }
        }
        return new ArrayList<>(result);
    }

}