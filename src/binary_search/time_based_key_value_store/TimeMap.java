package binary_search.time_based_key_value_store;

import java.util.*;

public class TimeMap {

    Map<String, Map<Integer, String>> datastore;

    public TimeMap() {
        datastore = new HashMap<String, Map<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        var element = this.datastore.get(key);
        if (element == null) {
            this.datastore.put(key, new HashMap<>() {{
                put(timestamp, value);
            }});
        } else {
            element.put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {
        var element = datastore.get(key);

        if (element == null) {
            return "";
        }

        if (element.get(timestamp) != null) {
            return element.get(timestamp);
        }

        var minIndexFound = -1;

        var keyList = new ArrayList<Integer>(element.keySet());
        Collections.sort(keyList);

        var left = 0;
        var right = keyList.size() - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            var midElement = keyList.get(mid);
            if (timestamp == midElement) {
                return element.get(midElement);
            } else if (midElement > timestamp) {
                right = mid - 1;
            } else {
                // midElement < timestamp
                // need to find the max value between the ones that are lower than my target
                minIndexFound = Math.max(minIndexFound, midElement);
                left = mid + 1;
            }
        }

        if (minIndexFound == -1) {
            return "";
        } else {
            return element.get(minIndexFound);
        }

    }
}
