package DSA_Java.LinkedList;

public class SortZeroOneTwoList {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 0, 1, 2, 1, 1, 0};

        Node head = convertArrayToLinkedList(arr);

        head = sortZeroOneTwoList(head);
        
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

    public static Node sortZeroOneTwoList(Node head){

        if(head == null){
            return null;
        }

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node temp = head;

        while(temp != null){

            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            } else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }

            temp = temp.next;
        }

        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }
}