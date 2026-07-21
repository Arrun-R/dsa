package DSA_Java.LinkedList;

public class RemoveDuplicates {
     public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,6,6,7,7};
        Node head = convertArrayToDoubleyLinkedList(arr);
        head = removeDuplicates(head);
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

    public static Node removeDuplicates(Node head){

        Node temp = head;

        while(temp != null && temp.next != null) {
           Node nextNode = temp.next;

           while(nextNode != null && nextNode.data==temp.data) {
                nextNode = nextNode.next;
           }

            temp.next = nextNode;
            if(nextNode != null){
                nextNode.prev = temp;
            }

            temp = temp.next;

        }

        return head;
    }
}
