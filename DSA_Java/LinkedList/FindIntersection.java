package DSA_Java.LinkedList;

public class FindIntersection {

    public static void main(String[] args) {
       
        Node common1 = new Node(8);
        Node common2 = new Node(9);

        common1.next = common2;

        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = common1;

        Node headB = new Node(3);
        headB.next = new Node(4);
        headB.next.next = common1;

        Node intersection = findIntersection(headA, headB);

        if(intersection == null){
            System.out.println("No intersection nodes found");
        } else {
            System.out.println("Intersection node found " + intersection.data);
        }
        
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

    public static Node findIntersection(Node headA, Node headB){

        if(headA == null || headB == null){
            return null;
        }

        Node temp1 = headA;
        Node temp2 = headB;

        while(temp1 != temp2){

            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1.next == null) {
                temp1 = headB;
            }

            if(temp2.next == null) {
                temp2 = headA;
            }
        }

        return temp1;
     }
}