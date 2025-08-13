package tries.implement_prefix_tree;

import java.util.Map;

public class PrefixTree {

    private class TrieNode {
        Boolean isLeaf;
        Map<Character, TrieNode> children;
    }

    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
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
        for (char key: word.toCharArray()){
            if(!current.children.containsKey(key)){
                return false;
            }
            current = current.children.get(key);
        }
        return current.isLeaf;
    }

    public boolean startsWith(String prefix) {
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
