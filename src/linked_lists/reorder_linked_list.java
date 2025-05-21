package linked_lists;


import linked_lists.utils.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class reorder_linked_list {
    public static void main(String[] args) {

                reorderList(
                        new ListNode(2,
                                new ListNode(4,
                                        new ListNode(6,
                                                new ListNode(8,
                                                        new ListNode(10,null)))))
                ).printList();
    }

    public static ListNode reorderList(ListNode head) {
        var currentNode = head;
        List<ListNode> nodeList = new ArrayList<>();

        while(currentNode!=null){
            nodeList.add(currentNode);
            currentNode = currentNode.next;
        }

        var size = nodeList.size();
        ListNode newHead = null;
        var inverse = true;
        var inverseCounter = (size);
        var forwardCounter = -1;
        while(forwardCounter!=inverseCounter){
            if(newHead == null){
                forwardCounter++;
                newHead = nodeList.get(forwardCounter);
                newHead.next=null;
                currentNode = newHead;

            } else {
                if(inverse){
                    inverseCounter--;
                    currentNode.next= nodeList.get(inverseCounter);
                    inverse = false;
                }else {
                    forwardCounter++;
                    currentNode.next= nodeList.get(forwardCounter);
                    inverse = true;
                }
                currentNode = currentNode.next;
                currentNode.next=null;
            }
        }
        return newHead;

    }

}