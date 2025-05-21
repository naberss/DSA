package linked_lists;


import linked_lists.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class remove_node_from_end_of_linked_list {
    public static void main(String[] args) {

        /*removeNthFromEnd(
                        new ListNode(2,
                                new ListNode(4,
                                        new ListNode(6,
                                                new ListNode(8,
                                                        new ListNode(10,null))))),
                2
                ).printList();*/


        System.out.println(removeNthFromEnd(
                new ListNode(2,null),
                1
        ));

        /*removeNthFromEnd(
                new ListNode(2,
                        new ListNode(4,null)),
                2
        ).printList();*/


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodelist = new ArrayList<>();
        var currentNode = head;

        while(currentNode !=null){
            nodelist.add(currentNode);
            currentNode = currentNode.next;

        }

        var nodeToBeRemoved = nodelist.get(nodelist.size()-n);
        if(nodeToBeRemoved==head){
            head = nodeToBeRemoved.next;
        } else {
            var previous = nodelist.get(nodelist.size()-(n+1));
            previous.next = nodeToBeRemoved.next;
        }


        return head;
    }

}