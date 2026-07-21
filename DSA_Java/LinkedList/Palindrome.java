package DSA_Java.LinkedList;

public class Palindrome {

    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 1, 5, 8};

        Node head = convertArrayToLinkedList(arr);
        
        System.out.println(palindrome(head));
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

    public static boolean palindrome(Node head){

        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow.next);

        Node left = head;
        Node right = newHead;

        while(right != null){
            if(left.data != right.data){
                reverse(newHead);
                return false;
            }
            left = left.next;
            right = right.next;
        }
        reverse(newHead);
        return true;

    }

    public static Node reverse(Node head){
        if(head == null || head.next == null) {
            return head;
        }

        Node newHead = reverse (head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    
}