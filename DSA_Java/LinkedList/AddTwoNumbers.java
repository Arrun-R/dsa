package DSA_Java.LinkedList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        int[] arr1 = {8, 5, 2};
        int[] arr2 = {4, 1, 9, 3, 6};

        Node num1 = convertArrayToLinkedList(arr1);
        Node num2 = convertArrayToLinkedList(arr2);

        Node head = addTwoNumbers(num1,num2);
        
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

    public static Node addTwoNumbers(Node num1, Node num2){
        
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;

        Node temp1 = num1;
        Node temp2 = num2;
        int sum = 0;
        int carry = 0;
        while(temp1 != null || temp2 != null){
            sum = carry;

            if(temp1 != null){
                sum = sum + temp1.data;
            }

            if(temp2 != null){
                sum = sum + temp2.data;
            }

            curr.next = new Node(sum%10);
            curr = curr.next;

            carry = sum/10;

            if(temp1 != null){
                temp1 = temp1.next;
            }

            if(temp2 != null){
                temp2 = temp2.next;
            }
        }

        if(carry > 0){
            curr.next = new Node(sum%10);
            curr = curr.next;
        }

        return dummyNode.next;
    }

}
