package binary_search.time_based_key_value_store;


public class time_based_key_value_store {
    public static void main(String[] args) {
        var timeMap = new TimeMap();

        timeMap.set("check", "one", 5);

        timeMap.set("check", "two", 10);

        System.out.println(timeMap.get("check", 7));

        System.out.println(timeMap.get("lalala", 7));



        System.out.println("debug time");
    }

}