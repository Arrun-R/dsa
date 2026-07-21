package DSA_Java.LinkedList;

public class DeleteAllOccurancesKey {
     public static void main(String[] args) {
        int[] arr = {8, 5, 2, 4, 1, 2};
        Node head = convertArrayToDoubleyLinkedList(arr);
        head = deleteAllOccurancesKey(head, 2);
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

    public static Node deleteAllOccurancesKey(Node head, int key){
        if(head == null) {
            return null;
        }

        Node temp = head;

        while (temp != null){

            if(temp.data == key) {

                if(temp == head){
                    head = head.next;
                }

                Node prevNode = temp.prev;
                Node nextNode = temp.next;

                if(nextNode != null){
                    nextNode.prev = temp.prev;
                }

                if(prevNode != null){
                    prevNode.next = temp.next;
                }

                temp = nextNode;
            
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}