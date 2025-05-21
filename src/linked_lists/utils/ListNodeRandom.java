package linked_lists.utils;

public class ListNodeRandom {

    public int val;
    public ListNodeRandom next;
    public ListNodeRandom random;

    public ListNodeRandom() {}

    public ListNodeRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public ListNodeRandom(int val, ListNodeRandom next, ListNodeRandom random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public void printList() {
        ListNodeRandom currentNode = this;
        while (currentNode != null) {
            String nextVal = (currentNode.next != null) ? String.valueOf(currentNode.next.val) : "null";
            String randomVal = (currentNode.random != null) ? String.valueOf(currentNode.random.val) : "null";
            System.out.println("{ \"val\": " + currentNode.val + ", \"next\": " + nextVal + ", \"random\": " + randomVal + " }");
            currentNode = currentNode.next;
        }
    }
}
