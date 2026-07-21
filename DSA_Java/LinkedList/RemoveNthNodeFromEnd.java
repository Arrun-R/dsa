package DSA_Java.LinkedList;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 9, 6, 3, 2};

        Node head = convertArrayToLinkedList(arr);

        head = removeNthNodeFromEnd(head, 1);
        
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

    public static Node removeNthNodeFromEnd (Node head, int d){
        if(head == null || d <= 0){
            return head;
        }

        Node fast = head;
        Node slow = head;

        for(int i=0; i<d; i++){
            if(fast == null){
                return head;
            }
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;

    }
}