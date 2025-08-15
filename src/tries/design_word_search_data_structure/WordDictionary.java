package tries.design_word_search_data_structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    public static class TrieNode {
        Boolean isLeaf = false;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        var current = this.root;
        for(char key: word.toCharArray()){
            if(!current.children.containsKey(key)){
                current.children.put(key, new TrieNode());
            }
            current = current.children.get(key);
        }
        current.isLeaf = true;
    }

    public boolean search(String word) {
        var current = this.root;
        var wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length;i++){
            if (wordArray[i] == '.'){
                if(current.children.isEmpty()){
                    return false;
                }
                for(Map.Entry<Character, TrieNode> set: current.children.entrySet()){
                    var newWord = Arrays.copyOfRange(wordArray, i+1, wordArray.length);
                    if(innerSearch(new String(newWord), set.getValue())){
                        return true;
                    };
                }
                return false;
            }
            else if (!current.children.containsKey(wordArray[i])){
                return false;
            }
            current = current.children.get(wordArray[i]);
        }
        return current.isLeaf;
    }


    private boolean innerSearch(String word, TrieNode customCurrent) {
        var wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length;i++){
            if (wordArray[i] == '.'){
                if(customCurrent.children.isEmpty()){
                    return false;
                }
                for(Map.Entry<Character, TrieNode> set: customCurrent.children.entrySet()){
                    var newWord = Arrays.copyOfRange(wordArray, i+1, wordArray.length);
                    if(innerSearch(new String(newWord), set.getValue())){
                        return true;
                    }
                }
                return false;
            }
            else if (!customCurrent.children.containsKey(wordArray[i])){
                return false;
            }
            customCurrent = customCurrent.children.get(wordArray[i]);
        }
        return customCurrent.isLeaf;
    }


}
