package DSA_Java.LinkedList;

public class FindLengthOfLoop {

    public static void main(String[] args) {

        // Creating Linked List
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a cycle:
        // 5 -> 3
        head.next.next.next.next.next = head.next.next;

        System.out.println(findLengthOfLoop(head));
        
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

    public static int findLengthOfLoop(Node head){

        if (head == null || head.next == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return findLength(slow,fast);
            }
        }

        return 0;
    }

    public static int findLength(Node slow, Node fast){

        int c = 1; fast = fast.next;

        while (slow != fast) {
            c++;
            fast = fast.next;
        }

        return c;
    }

}