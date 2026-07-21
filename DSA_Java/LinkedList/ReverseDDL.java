package DSA_Java.LinkedList;

public class ReverseDDL {
     public static void main(String[] args) {
        int[] arr = {8, 5, 2, 4, 1};
        Node head = convertArrayToDoubleyLinkedList(arr);
        head = reverseNode(head);
        printDoubleyLinkedListValues(head);

     }

     static class Node {
        int data;
        Node next;
        Node prev;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public static Node convertArrayToDoubleyLinkedList(int[] arr){
        if(arr.length == 0){
            return null;
        }

        Node newNode = new Node(arr[0]);
        Node temp = newNode;

        for(int i=1;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp.next.prev = temp;
            temp = temp.next;
        }

        return newNode;
    }

    public static void printDoubleyLinkedListValues (Node head){
        Node temp = head;
		while(temp != null){
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
    }

    public static Node reverseNode(Node head){
        if(head == null || head.next == null){
            return head;
        }

        
        Node temp = head;
        Node prevNode = null;

        while(temp != null){
            prevNode = temp.prev;
            temp.prev = temp.next;
            temp.next = prevNode;

            temp = temp.prev;
        }

        return prevNode.prev;
    }
}
