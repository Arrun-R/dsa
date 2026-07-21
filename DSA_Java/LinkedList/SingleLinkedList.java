package DSA_Java.LinkedList;

public class SingleLinkedList {

    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 4, 1};
        Node head = convertArrayToLinkedList(arr);

        // Deletion
        //head = deleteHeadNode(head);
        //head = deleteTailNode(head);
        //head = deletePositionNode(head,2);
        //head = deleteValueNode(head, 8);

        // Insertion
        //head = insertHeadNode(head, 7);
        //head = insertTailNode(head, 9);
        //head = insertPositionNode(head, 3, 7);
        //head = insertValueBeforeNode(head,2,3);
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



    // delete Head Node
    public static Node deleteHeadNode(Node head){
        if(head == null){
            return null;
        }

        return head.next;
    }

    //delete Tail Node
    public static Node deleteTailNode(Node head){
        if(head == null || head.next == null){
            return null;
        }
        
        Node temp = head;

        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    
    //delete Position Node
    public static Node deletePositionNode(Node head, int p){
        if(head == null || p<= 0){
            return null;
        }

        if(p == 1){
            return head.next;
        }

        int c = 1;
        Node temp = head;
        
        while(c<p-1 && temp.next != null){
            temp = temp.next;
            c++;
        }

        if(temp.next == null){
            return head;
        }
        temp.next = temp.next.next;

        return head;
    }

    // delete Value Node
    public static Node deleteValueNode(Node head, int v){
        if(head == null){
            return null;
        }
        if(head.data == v){
            return head.next;
        }
        Node temp = head;
        Node prev = null;

        while(temp != null){
            if(temp.data == v){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }


        return head;
    }

    // insert Head Node
    public static Node insertHeadNode(Node head, int val){
        return new Node(val,head);
    }

    // insert Tail Node
    public static Node insertTailNode(Node head, int val){
        if(head == null){
            return new Node(val);
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(val);

        return head;
    }

    // insert Position Node
    public static Node insertPositionNode(Node head, int p, int val){
        if(head == null){
            if(p==1){
                return new Node(val);
            } else {
                return null;
            }
        }

        if(p==1){
            return new Node(val,head);
        }

        int c = 1;
        Node temp = head;
        while (c<p-1 && temp != null){
            c++;
            temp = temp.next;
        }

        if(temp == null){
            return head;
        }

        Node add = new Node(val, temp.next);
        temp.next = add;

        return head;
    }

    public static Node insertValueBeforeNode(Node head, int v, int val){
        if(head == null){
            return new Node(val);
        }

        if(head.data == v){
            return new Node(val,head);
        }

        Node temp = head;

        while(temp.next != null){
            if(temp.next.data == v){
                Node add = new Node(val, temp.next);
                temp.next = add;
                break;
            }
            temp = temp.next;
        }

        return head;

    }
}
