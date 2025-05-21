package linked_lists;

import linked_lists.utils.ListNodeRandom;

import java.util.*;

public class copy_linked_list_with_random_pointer {
    public static void main(String[] args) {

        var t1 = new ListNodeRandom(3,null,null);
        var t2 = new ListNodeRandom(7,null,null);
        var t3 = new ListNodeRandom(4,null,null);
        var t4 = new ListNodeRandom(5,null,null);

        //next
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;

        //random
        t1.random = null;
        t2.random = t4;
        t3.random = t1;
        t4.random = t2;

        var response = copyRandomList(null);
        if (response!=null){
            response.printList();
        }
    }

    public static ListNodeRandom copyRandomList(ListNodeRandom head) {
        var sourceNodeList = new ArrayList<ListNodeRandom>();
        var randomNodeIndexMap = new HashMap<ListNodeRandom, Integer>();

        if(head==null){
            return null;
        }

        var current = head;
        while (current!=null){
            var newNode = new ListNodeRandom(current.val, null ,current.random);
            sourceNodeList.add(newNode);

            if(!randomNodeIndexMap.containsKey(current.random) && current.random!=null) {
                randomNodeIndexMap.put(current.random, null);
            }

            current = current.next;
        }


        current = head;
        int counter = 0;
        while (current!=null){
            if(randomNodeIndexMap.containsKey(current)){
                randomNodeIndexMap.put(current, counter);
            }

            counter++;
            current = current.next;
        }


        for(int i =0; i <sourceNodeList.size(); i++){
            if((i+1)<sourceNodeList.size()){
                sourceNodeList.get(i).next = sourceNodeList.get(i+1);
            }

            var randomPosition = randomNodeIndexMap.get(sourceNodeList.get(i).random);
            if(randomPosition!=null){
                sourceNodeList.get(i).random = sourceNodeList.get(randomPosition);
            }
        }

        return sourceNodeList.getFirst();

    }

}