package tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Boolean isLeaf;
    Map<Character, TrieNode> children = new HashMap<>();
}
