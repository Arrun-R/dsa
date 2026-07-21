package DSA_Java.LinkedList;

public class AddOneToANumber {

    public static void main(String[] args) {
        int[] arr = {9,9,1,9,9};

        Node head = convertArrayToLinkedList(arr);

        head = addOneToANumber(head);
        
        printLinkedListValues(head);
    }


    public static Node convertArrayToLinkedList(int[] arr) {
        if(arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node current = head;
        
        for(int i=1; i<arr.length; i++) {
			Node temp = new Node(arr[i]);
			current.next = temp;
			current = current.next;
		}
		return head;
    }
	
	public static void printLinkedListValues(Node head) {
		Node temp = head;
		while(temp != null){
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}


    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node addOneToANumber(Node head){
        int carry = addingOneRecursively(head);

        if(carry == 1){
            Node newHead = new Node(1);
            newHead.next = head;

            head = newHead;
        }

        return head;
        
    }

     public static int addingOneRecursively(Node temp){
        if(temp == null){
            return 1;
        }

        int carry = addingOneRecursively(temp.next);

        temp.data = temp.data + carry;

        if(temp.data < 10) {
            return 0;
        } else {
            temp.data = 0;
            return 1;
        }

    }
}