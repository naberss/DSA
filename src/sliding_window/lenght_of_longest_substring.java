package sliding_window;


import java.util.HashSet;

public class lenght_of_longest_substring {
    public static void main(String[] args) {
        System.out.println(
                lengthOfLongestSubstring("thequickbrownfoxjumpsoverthelazydogthequickbrownfoxjumpsovert")
        );
    }

    public static int lengthOfLongestSubstring(String s) {
        var left = 0;
        var right = 0;
        var set = new HashSet<String>();
        var maxSeq = -99999;

        if(s.length()==0){
            return 0;
        }

        var array = s.split("");

        while(right < array.length){
            var current = array[right];
            while(set.contains(current)){
                set.remove(array[left]);
                left++;
            }
            set.add(current);
            right++;

            maxSeq = Math.max((set.size()), maxSeq);
        }
        return maxSeq;
    }

}