package arrays_questions;

import java.util.Arrays;
import java.util.Objects;

public class isAnagram {
    public static void main(String[] args) {
        isAnagram("xx", "x");
    }

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

            var sArray = s.split("");
            var tArray = t.split("");

            Arrays.sort(sArray);
            Arrays.sort(tArray);

            for (int i = 0; i< s.length();i++){
                if(!sArray[i].equals(tArray[i])){
                    return false;
                }
            }
        return true;
    }



}