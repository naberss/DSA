package tries;

import java.util.HashMap;
import java.util.Map;

//insert (inserts new children)
//search (boolean indicating the word was found)
//startsWith (receives an prefix and serch among root's children)

public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    // iterates through children array
    // if no children matching the given key if found it creates a new children from previous root and adds the given key
    // when you get at the end of the insertion it sets the last valid node to isLeaf = true meaning its the end of current branch
    // if the current word is already mapped it resets the last valid children node to isLeaf
    public void insert(String word){
        var current = this.root;
        for(char key: word.toCharArray()){
            if(!current.children.containsKey(key)){
                current.children.put(key, new TrieNode());
            }
            current = current.children.get(key);
        }
        current.isLeaf = true;
    }

    // iterates over root's children
    // if key not found in given children is because there is no word for it down the branches given its prefix
    // if the iteration goes to the end of the characters in the word that means you found a candidate...
    // but this candidate might not be marked as a word so you return the identifier on it nad not plain 'True'
    public Boolean search(String word){
        var current = this.root;

        for (char key: word.toCharArray()){
            if(!current.children.containsKey(key)){
                return false;
            }
            current = current.children.get(key);
        }
        return current.isLeaf;
    }

    // iterates over root's children
    // if key not found in given children is because there is no word for it down the branches given its prefix
    // if the iterarion goes until the last char on prefix string, it means you found a matching prefix, thus you should return True
    public Boolean startsWith(String prefix){
        var current = this.root;
        for (char key: prefix.toCharArray()){
            if(!current.children.containsKey(key)){
                return false;
            }
            current = current.children.get(key);
        }
        return true;
    }



}
