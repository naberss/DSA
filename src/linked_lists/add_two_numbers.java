package linked_lists;

import linked_lists.utils.ListNode;
import linked_lists.utils.ListNodeRandom;

import java.util.ArrayList;
import java.util.HashMap;

public class add_two_numbers {
    public static void main(String[] args) {


        addTwoNumbers(
                new ListNode(1,new ListNode(2,new ListNode(3,null))),
                new ListNode(4,new ListNode(5,new ListNode(6,null)))
        ).printList();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        var currentL1 = l1;
        var l1List = new ArrayList<Integer>();

        var currentL2 = l2;
        var l2List = new ArrayList<Integer>();

        while(currentL1!=null){
            l1List.add(currentL1.val);
            currentL1 = currentL1.next;
        }

        while(currentL2!=null){
            l2List.add(currentL2.val);
            currentL2 = currentL2.next;
        }


        var L1OrderedString = new StringBuilder();
        for(int i = 1; i <=l1List.size(); i++){
            L1OrderedString.append(l1List.get(l1List.size()-i));
        }


        var L2OrderedString = new StringBuilder();
        for(int i = 1; i <=l2List.size(); i++){
            L2OrderedString.append(l2List.get(l2List.size()-i));
        }

        int l1Integer = Integer.parseInt(L1OrderedString.toString());
        int l2Integer = Integer.parseInt(L2OrderedString.toString());
        String[] finalSumArray = String.valueOf(l1Integer + l2Integer).split("");


        ListNode finalHead = null;
        ListNode current = null;
        for(int i = 1; i<=finalSumArray.length; i++){

            if(finalHead==null){
                finalHead = new ListNode(Integer.parseInt(finalSumArray[finalSumArray.length-i]));
                current = finalHead;
            }

            if(i+1<=finalSumArray.length){
                current.next = new ListNode(Integer.parseInt(finalSumArray[finalSumArray.length-(i+1)]));
            }

            current = current.next;
        }

        return finalHead;
    }

}