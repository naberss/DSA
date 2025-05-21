package sliding_window;

import java.util.HashSet;

public class longest_repeating_character_replacement {
    public static void main(String[] args) {
        System.out.println(
                characterReplacement("AAABABB", 1)
        );
    }

    public static int characterReplacement(String s, int k) {
        var set = new HashSet<String>();
        var splitedArray = s.split("");
        var finalResponse = -99999;

        // create a set with all distinct digits in the sequence
        for (String node: splitedArray){
            set.add(node);
        }

        // looping through the set array, means you will try every possibility of the sliding window strategy, having as `mostFrequentChar`...
        // ... all the distinct chars present on the source string
        for(String node: set){
            var countMostFrequent = 0;
            var left = 0;

            // starting the sliding window strategy
            for(int right = 0;right<splitedArray.length;right++) {

                // every time the right cursor moves check if the referenced char is equal to the one in the higher iteration (set)
                // if it is equal that means the element displayed by the right cursor is to be considered as an instance of the most frequent char
                if(splitedArray[right].equals(node)){
                    countMostFrequent++;
                }

                // this logic infers that ((windowSize - mostFrequentElementCount)<=k) is a valid sequence, thus it would ignore this `while` statement and jump back to right++...
                // ... moving the right cursor forward and incrementing the window size.

                // on the invalid scenario as ((windowSize - mostFrequentElementCount)>k), we would first check if the left cursor is standing on a element equal to the `mostFrequentChar`...
                // ... if yes we would decrement it, because the left cursor would now walk forward, meaning the window is shrinking
                // this snippet is actually what rebalances the window when it is not valid anymore
                while(!(right-left+1-countMostFrequent<=k)){
                    if(splitedArray[left].equals(node)){
                        countMostFrequent--;
                    }
                    left++;
                }

                // finalResponse is always a check for the max size of a valid windows tested previously
                finalResponse = Math.max(finalResponse, right-left+1);

            }
        }
        return finalResponse;
    }

}