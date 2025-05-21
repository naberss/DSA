package arrays_questions;

import java.util.ArrayList;
import java.util.List;

public class string_encode_and_decode {
    public static void main(String[] args) {
        var input = new ArrayList<String>();
        var encodedString = encode(input);
        decode(encodedString).forEach(t ->
                System.out.println(t)
        );
    }

    public static String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        if(strs.isEmpty()){
            return builder.toString();
        }

        var sizes = new ArrayList<Integer>();
        strs.forEach( string ->
                sizes.add(string.length())
        );

        sizes.forEach(size -> {
            builder.append(size);
            builder.append(",");
        });

        builder.append("#");

        strs.forEach(string -> {
           builder.append(string);
        });

        return builder.toString();
    }

    public static List<String> decode(String str) {
        var finalList = new ArrayList<String>();

        if (str.isEmpty()){
            return finalList;
        }

        var sizeRawString = new StringBuilder();
        var remainingRawString = new StringBuilder();
        var initialCharList = str.split("");

        for (int i =0; i<=initialCharList.length; i++){
            if(!initialCharList[i].equals("#")){
                sizeRawString.append(initialCharList[i]);
                initialCharList[i]=null;
            } else {
                initialCharList[i]=null;
                break;
            }
        }

        for (String s : initialCharList) {
            if (s != null) {
                remainingRawString.append(s);
            }
        }

        var sizeArray = sizeRawString.toString().split(",");
        var remainingRawArray = remainingRawString.toString().split("");

        for(String size: sizeArray){
            var sizeCounter = 0;
            var newStr = new StringBuilder();
            if(Integer.parseInt(size)!=0){
                for(int i =  0; i <remainingRawArray.length; i++ ){
                    if(remainingRawArray[i]!=null){
                        if(sizeCounter!=Integer.parseInt(size)){
                            newStr.append(remainingRawArray[i]);
                            sizeCounter++;
                            remainingRawArray[i]=null;
                        } else {
                            break;
                        }
                    }
                }
            }
            finalList.add(newStr.toString());
            }

        return finalList;
    }



}