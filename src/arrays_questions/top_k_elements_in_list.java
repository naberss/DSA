package arrays_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class top_k_elements_in_list {
    public static void main(String[] args) {
        var t = topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2);
        System.out.println("response: " + Arrays.toString(t));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        var finalResult = new int[k];
        for(int i:nums){
            var t= map.get(i);
            if (t==null){
                map.put(i, 1);
            } else {
                t++;
                map.put(i, t);
            }
        }

        for (int j = 0; j < k; j++){
            var highestValue = 0;
            var highestKey = 0;
            for(Map.Entry<Integer, Integer> entry:map.entrySet()){
                var value = entry.getValue();
                if (entry.getValue()>highestValue){
                    highestValue = value;
                    highestKey = entry.getKey();

                }
            }
            map.remove(highestKey);
            finalResult[j] = highestKey;
        }


    return finalResult;
    }



}