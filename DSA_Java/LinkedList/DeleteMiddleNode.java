package DSA_Java.LinkedList;

public class DeleteMiddleNode {

    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 9, 7, 3};

        Node head = convertArrayToLinkedList(arr);
        
        head = deleteMiddleNode(head);

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

    public static Node deleteMiddleNode(Node head){

        Node slow = head;
        Node fast = head;
        
        fast = fast.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}