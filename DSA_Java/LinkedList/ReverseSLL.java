package DSA_Java.LinkedList;

public class ReverseSLL {

    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 4, 6, 1, 7};

        Node head = convertArrayToLinkedList(arr);

        head = reverseSLL(head);
        
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

    // public static Node reverseSLL(Node head) {

    //     if(head == null || head.next == null){
    //         return head;
    //     }

    //     Node temp = head;
    //     Node prev = null;

    //     while(temp != null){
    //         Node front = temp.next;
    //         temp.next = prev;
    //         prev = temp;
    //         temp = front;
    //     }

    //     return prev;

    // }

    public static Node reverseSLL(Node head) {

        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverseSLL(head.next);
        Node temp = head.next;
        temp.next = head;
        head.next = null;

        return newHead;
    }
}
