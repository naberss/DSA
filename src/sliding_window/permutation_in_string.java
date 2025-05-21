package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class permutation_in_string {
    public static void main(String[] args) {
        System.out.println(
                checkInclusion("abc", "lecabee")
        );
    }

    public static boolean checkInclusion(String s1, String s2) {
        var s1Array = s1.split("");
        var s2Array = s2.split("");
        var s1Lenght = s1Array.length;

        var left = 0;
        int counter = left;
        var s2WindowArray = new ArrayList<String>();

        while(counter<(s1Lenght-1)){
            s2WindowArray.add(s2Array[counter]);
            counter++;

        }

        for(int right = s1Lenght-1;right < s2.length(); right++) {
            s2WindowArray.add(s2Array[right]);

            var  s1ArrayCopy = new ArrayList<>(Arrays.stream(s1Array).toList());
            var count = 0;

            for(String node :s2WindowArray){
                if(count>0 && s1ArrayCopy.size() == s1Array.length){
                    break;
                }
                for(int i =0; i < s1ArrayCopy.size(); i++){
                    if(node.equals(s1ArrayCopy.get(i))){
                        s1ArrayCopy.remove(i);
                    }
                }
                count++;
            }
            if (s1ArrayCopy.isEmpty()){
                return true;
            } else {
                s2WindowArray.remove(0);
                left++;
            }
        }
        return false;
    }

}