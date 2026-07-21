package DSA_Java.LinkedList;

import java.util.*;
public class FindPairsOfDLL {
     public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        Node head = convertArrayToDoubleyLinkedList(arr);
        List<List<Integer>> pairsList = findPairsOfDLL(head, 6);
        
        pairsList.forEach(pair -> System.out.println(pair.get(0) +"  "+pair.get(1)));

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

    public static List<List<Integer>> findPairsOfDLL (Node head, int sum){
       
        Node temp = head;
        Node left = temp;
        Node right = findTail(temp);

        List<List<Integer>> pairs = new ArrayList<>();

        while (left.data < right.data) {

            if(left.data + right.data == sum){
                pairs.add(Arrays.asList(left.data, right.data));
                left = left.next;
                right = right.prev;
            } else if (left.data + right.data < sum) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }

        return pairs;
    }

    public static Node findTail(Node head) {
        while (head.next != null){
            head = head.next;
        }

        return head; 
    }
}