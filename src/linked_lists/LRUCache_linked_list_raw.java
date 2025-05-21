package linked_lists;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_linked_list_raw {

    // this node class will hold order of the elements when it comes to which is the most recent
    public class Node {

        public int val;
        public int key;
        public Node prev;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int key,int val) {
            this.val = val;
            this.key = key;
        }
    }

    // cache for O1 access to elements
    private Map<Integer, Node> cache;
    // represents the least recent edge of the list
    private Node left;
    // represents most recent edge of the list
    private Node right;
    private int capacity;

    public LRUCache_linked_list_raw(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Node>();

        // left and right here can be initialized with whatever key-value pair because they will not be accessed directly...
        // at this point they are only placeholders, the actual nodes we care about are the ones in the middle of those two
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        //connect both nodes
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    // simply removes the refs. of the node from its neighbours
    public void remove(Node node){
        var prev = node.prev;
        var next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // this will always insert a new node at the most right position before `this.right` meaning a new most recent element
    public void insert(Node node){
        var right = this.right;
        var rightPrev = right.prev;

        rightPrev.next = node;

        node.prev = rightPrev;
        node.next = right;

        right.prev = node;
    }

    // checks key presence in cache and then fetches it and update its position on the ordering list
    public int get(int key) {
        if(cache.containsKey(key)){
            var foundNode = cache.get(key);
            remove(foundNode);
            insert(foundNode);
            return foundNode.val;
        }
        return - 1;
    }

    // overrides or insert a new element and updates ordering list
    // also checks if the addition of a new element has surpassed its capacity, if it does then remove the least recently used element from both cache (o1) and ordering list
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        var newNode = new Node(key, value);
        cache.put(key,newNode);
        insert(newNode);

        if(cache.size() > capacity){
            var lru = this.left.next;
            remove(lru);
            // this is why `Node` object needs to have the key ref. as when I need to evict lru I already have access to the element in cache on the fly
            cache.remove(lru.key);
        }
    }
}
