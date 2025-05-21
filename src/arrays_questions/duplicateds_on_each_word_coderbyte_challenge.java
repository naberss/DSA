package arrays_questions;

import java.util.*;

public class duplicateds_on_each_word_coderbyte_challenge {
    public static void main(String[] args) {
        System.out.println(duplicatedLetters(new String[]{"bella","label","roller"}));
    }

    public static List<String> duplicatedLetters(String[] strs) {
        if(strs.length==0){
            return new ArrayList<>();
        }

        var mapList = new ArrayList<HashMap<String, Integer>>();

        for(String word: Arrays.stream(strs).toList()){
            var map = new HashMap<String, Integer>();
            var splited = word.split("");
            for(String letter: splited){
                var value = map.get(letter);
                if(value==null){
                    map.put(letter, 1);
                } else {
                    map.put(letter, value+1);
                }
            }
            mapList.add(map);
        }

        var index = mapList.get(0);
        mapList.remove(0);

        for(HashMap<String, Integer> mapp: mapList){
            var iterator = index.entrySet().iterator();
            while(iterator.hasNext()){
                var indexEntry = iterator.next();
                var value = mapp.get(indexEntry.getKey());
                if(value==null){
                    iterator.remove();
                } else {
                    index.put(indexEntry.getKey(), value);
                }
            }
        }

        var result = new ArrayList<String>();
        for(var finalIndex: index.entrySet()){
            var counter = finalIndex.getValue();
            while(counter>0){
                result.add(finalIndex.getKey());
                counter--;
            }
        }

        return result;
    }



}