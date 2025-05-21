package arrays_questions;

import java.util.*;
import java.util.stream.Collectors;

public class anagram_groups {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"x","act","pots","tops","cat","stop","hat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> finalAnagramGroups = new ArrayList<>();
        Map<String,List<String>> aux = new HashMap<>();
        var strsLower = Arrays.stream(strs).collect(Collectors.toList());


        for (int i = 0; i < strs.length; i++){

            List<String> currentList = new ArrayList<String>();

            var ordered1 = strs[i].split("");
            Arrays.sort(ordered1);

            var string1 = String.join("", ordered1);

            for (int j = 0; j < strsLower.size(); j++){

                if(j>i){
                    var lowerValue = strsLower.get(j);
                    if (lowerValue!=null && strs[i].length() == lowerValue.length()){

                        var ordered2 = strsLower.get(j).split("");
                        Arrays.sort(ordered2);

                        if(Arrays.equals(ordered1, ordered2)){
                            currentList.add(strsLower.get(j));

                            strsLower.set(j, null);
                        }
                    }
                }
            }

            var currentValue = aux.get(string1);
            if(currentValue!=null){
                currentValue.addAll(currentList);
                aux.put(string1, currentValue);
            } else {
                if (currentList.isEmpty()){
                    aux.put(string1, Collections.singletonList(strs[i]));
                } else{
                    currentList.add(strs[i]);
                    aux.put(string1, currentList);
                }
            }
        }

        for (List<String> row: aux.values()){
            finalAnagramGroups.add(new ArrayList<>(row));
        }
        return finalAnagramGroups;

    }



}