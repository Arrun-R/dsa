package DSA_Java.LinkedList;

public class DoubleyLinkedList {
     public static void main(String[] args) {
        int[] arr = {8, 5, 2, 4, 1};
        Node head = convertArrayToDoubleyLinkedList(arr);

        //Deletion
        //head = deleteHeadNode(head);
        //head = deleteTailNode(head);
        //head = deletePositionNode(head, 1);
        //head = deleteValueNode(head, 1);

        //Insertion
        //head = insertHeadNode(head,7);
        //head = insertTailNode(head,7);
        //head = insertPositionNode(head, 1, 9);
        head = insertValueNode(head,2,9);
        printDoubleyLinkedListValues(head);

     }

     static class Node {
        int data;
        Node next;
        Node prev;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public static Node convertArrayToDoubleyLinkedList(int[] arr){
        if(arr.length == 0){
            return null;
        }

        Node newNode = new Node(arr[0]);
        Node temp = newNode;

        for(int i=1;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp.next.prev = temp;
            temp = temp.next;
        }

        return newNode;
    }

    public static void printDoubleyLinkedListValues (Node head){
        Node temp = head;
		while(temp != null){
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
    }

    //delete Head Node
    public static Node deleteHeadNode(Node head){
        if(head == null || head.next == null){
            return null;
        }

       Node temp = head.next;
       temp.prev = null;
       head.next = null;

       return temp;

    }

    //delete Tail Node
    public static Node deleteTailNode(Node head){
        if(head == null || head.next==null){
            return null;
        }

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next.prev = null;
        temp.next = null;

        return head;
    }

    // delete Position Node
    public static Node deletePositionNode(Node head,int p){
        if(head == null){
            return null;
        }

        if(p == 1){
            
            Node newHead = head.next;
            if(newHead != null){
                newHead.prev = null;
            }
            head.next = null;

            return newHead;
        }

        Node temp = head;
        int c = 1;
        while(c<p && temp != null){
            c++;
            temp = temp.next;
        }

        if(temp == null){
            return head;
        }

        if(temp.next != null) {
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        } else {
            temp.prev.next = null;
            temp.prev = null;
        }
       

        return head;
    }

    // delete Value Node
    public static Node deleteValueNode(Node head,int v){
        if(head == null){
            return null;
        }

        Node temp = head;

        while(temp != null){
            if(v == temp.data){
                break;
            }
            temp = temp.next;
        }

        if(temp == null){
            return head;
        }

        if(temp.prev == null && temp.next == null){
            return null;
        } else if(temp.prev == null){
           temp.next.prev = null;
           temp.next = null;
           
        } else if(temp.next == null){
            temp.prev.next = null;
            temp.prev= null;
        } else{
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;

            
        }
        return head;
    }

    //insert Head Node
    public static Node insertHeadNode(Node head, int val){
        if(head == null){
            return new Node(val);
        }

       Node newHead = new Node(val);
       newHead.next = head;
       head.prev = newHead;

       return newHead;

    }

    //insert Tail Node
    public static Node insertTailNode(Node head, int val){
        if(head == null){
            return new Node(val);
        }
       
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        Node newNode = new Node(val);
        temp.next = newNode;
        newNode.prev = temp;

        return head; 
    }


    //insert Position Node
    public static Node insertPositionNode(Node head, int p, int val){
        
        if(head == null){
            if(p==1){
                return new Node(val);
            }
            return null;
        }

        if(p==1){
            return new Node(val,head,null);
        }

        Node temp = head;
        int c = 0; 

        while (temp != null){
            c++;
            if(c==p){
                break;
            }
            temp = temp.next;
        }

        if (temp == null) {
            return head;
        }


        Node prevNode = temp.prev;
        Node newNode = new Node(val,temp,prevNode);

        temp.prev = newNode;
        prevNode.next = newNode;

        return head;
    }
    

    //insert Value Node
    public static Node insertValueNode(Node head, int v, int val){
        
        if(head == null){
            return null;
        }

        if(head.data==v){
            return new Node(val,head,null);
        }

        Node temp = head;

        while (temp != null){
            if(temp.data==v){
                break;
            }
            temp = temp.next;
        }

        if (temp == null) {
            return head;
        }


        Node prevNode = temp.prev;
        Node newNode = new Node(val,temp,prevNode);

        temp.prev = newNode;
        prevNode.next = newNode;

        return head;
    }
}