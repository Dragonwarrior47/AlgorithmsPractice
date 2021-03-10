package DataStructures;

public class LinkedList {
    public ListNode head;

    LinkedList(){

    }

    public void insertNode(int val){
        ListNode node = new ListNode(val);
        if (head == null) {
            this.head = node;

        }
        else{
            node.next = head;
            head = node;
        }
    }

    public void printLL(){
        ListNode currentNode = this.head;
        while(currentNode != null){
            if (currentNode.next != null)
            System.out.print(currentNode.val + "->");
            else
                System.out.print(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    public ListNode reverseLL(ListNode currentNode){

        if ( currentNode == null || currentNode.next == null){
            return currentNode;
        }
        ListNode rest = reverseLL(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null;
        return rest;




    }

    public ListNode reverse_k_ll(ListNode head, int k){
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        int count = 0;
        while (count < k && next != null){
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
            count ++;

        }
        if (count < k){
            current.next = prev;
            prev = current;
        }
        else {
            head.next = current;
        }
        return prev;
    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.insertNode(13);
        ll.insertNode(12);
        ll.insertNode(11);
        ll.insertNode(10);
        ll.insertNode(9);
        ll.insertNode(8);
        int n = 6;
        int k = 6;
        ll.printLL();
        System.out.println();
        ll.head = ll.reverse_k_ll(ll.head, n-k);
        ll.printLL();
        System.out.println();
        ll.head = ll.reverse_k_ll(ll.head, n);
        ll.printLL();
        System.out.println();
        ll.head = ll.reverse_k_ll(ll.head, k);
        ll.printLL();
        System.out.println();
    }

}
