package linked_lists;


import linked_lists.utils.ListNode;

import java.util.HashMap;
import java.util.Stack;

public class linked_list_cycle_detection {
    public static void main(String[] args) {

        var ListNode1 = new ListNode(0);
        var ListNode2 = new ListNode(1);
        var ListNode3 = new ListNode(2);

        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode1;




        System.out.println(hasCycle(ListNode1));
    }

    public static boolean hasCycle(ListNode head) {

        var map = new HashMap<ListNode, Integer>();
        int counter = 0;

        while (true){
            if (head!=null){
                if(counter==0){
                    map.put(head, counter);
                    head = head.next;
                } else {
                    if (head.next!=null){
                        var hasNextHead = map.get(head.next);
                        if (hasNextHead!=null){
                            return true;
                        } else {
                            map.put(head.next,0);
                            head = head.next;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
            counter++;
        }
        return false;
    }

}