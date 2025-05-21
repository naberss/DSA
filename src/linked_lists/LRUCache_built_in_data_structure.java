package linked_lists;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_built_in_data_structure {
    private final Map<Integer, Integer> cache;
    private final int capacity;

    public LRUCache_built_in_data_structure(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {



            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache_built_in_data_structure.this.capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
