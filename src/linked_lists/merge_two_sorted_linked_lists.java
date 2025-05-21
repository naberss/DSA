package linked_lists;


import linked_lists.utils.ListNode;

public class merge_two_sorted_linked_lists {
    public static void main(String[] args) {
        mergeTwoLists(
                new ListNode(1,new ListNode(2,new ListNode(4))),
                new ListNode(1,new ListNode(3,new ListNode(5)))
        ).printList();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1==null || list2==null){
            return list1==null?list2:list1;
        }

        ListNode result = null;
        ListNode resultTail = null;
        while (true){
            //checks if L1 and L2 current nodes are not null thus iterable
            if (list1!=null && list2!=null){

                // here only cases where at least one of the nodes still has a chain (L1 and L2 have values)
                if(list1.next!=null || list2.next!=null){

                    // comparation between different values on both nodes (L1 and L2 have values)
                    if(list1.val > list2.val){
                        if(result == null){
                            resultTail = new ListNode(list2.val);
                            result = resultTail;
                        } else {
                            var temp = new ListNode(list2.val);
                            resultTail.next = temp;
                            resultTail = temp;
                        }
                        list2 = list2.next;

                      // comparation between different values on both nodes (L1 and L2 have values)
                    } else if (list2.val > list1.val){
                        if(result == null){
                            resultTail = new ListNode(list1.val);
                            result = resultTail;
                        } else {
                            var temp = new ListNode(list1.val);
                            resultTail.next = temp;
                            resultTail = temp;
                        }
                        list1 = list1.next;

                      // equality between values on both nodes (L1 and L2 have values)
                    } else {
                        if(result == null){
                            resultTail = new ListNode(list2.val);
                            result = new ListNode(list1.val, resultTail);
                        } else {
                            var temp = new ListNode(list2.val);
                            resultTail.next = new ListNode(list1.val, temp);
                            resultTail = temp;
                        }
                        list1 = list1.next;
                        list2 = list2.next;
                    }

                    // start handling cases where at least one of the nodes still has a chain (L1 and L2 have values)
                }  else {
                    if(list1.val > list2.val){
                        var temp = new ListNode(list1.val);
                        if (result  == null){
                            result = new ListNode(list2.val, temp);
                        } else {
                            resultTail.next = new ListNode(list2.val, temp);
                        }
                    } else {
                        var temp = new ListNode(list2.val);
                        if (result == null){
                            result = new ListNode(list1.val, temp);
                        } else {
                            resultTail.next = new ListNode(list1.val, temp);
                        }
                    }
                    break;
                }

              // Start handling cases where at least one of the nodes is still iterable (L1 or L2 have values)
            } else {
                // only L1 is iterable and (has a chain or not)
                if (list1 !=null){
                    if (list1.next!=null){
                        var temp = new ListNode(list1.val);
                        resultTail.next = temp;
                        resultTail = temp;
                        list1 = list1.next;
                    } else {
                        resultTail.next = new ListNode(list1.val);
                        break;
                    }

                 // only L2 is iterable and (has a chain or not)
                }else if (list2 !=null){
                    if (list2.next!=null){
                        var temp = new ListNode(list2.val);
                        resultTail.next = temp;
                        resultTail = temp;
                        list2 = list2.next;
                    } else {
                        resultTail.next = new ListNode(list2.val);
                        break;
                    }
                  // both L1 and L2 have ended, meaning not more elements to iterate
                } else {
                    break;
                }
            }
        }
        return result;

    }

}