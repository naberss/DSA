package linked_lists;


import linked_lists.utils.ListNode;

import java.util.Stack;

public class reverse_linked_list {
    public static void main(String[] args) {
        System.out.println(
                reverseList(
                        new ListNode(0,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(3, null))))
                )
        );
    }

    public static ListNode reverseList(ListNode head) {
        var stack = new Stack<Integer>();
        var currentNode = head;

        if (currentNode == null){
            return null;
        }

        while (true){
            stack.push(currentNode.val);
            if(currentNode.next == null){
                break;
            }
            currentNode = currentNode.next;
        }

        ListNode result = null;
        ListNode resultHead = null;
        while (!stack.isEmpty()){
            if (result == null){
                result = new ListNode(stack.pop());
                resultHead = result;
            } else {
                result.next = new ListNode(stack.pop());
                result = result.next;
            }
        }

        return resultHead;
    }

}