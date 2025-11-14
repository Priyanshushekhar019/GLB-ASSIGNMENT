import java.util.*;

public class searchnodeinLL {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public static int searchNode(ListNode head, int target) {
        ListNode current = head;
        int index = 0;
        while (current != null) {
            if (current.val == target) {
                return index; 
            }
            current = current.next;
            index++;
        }
        return -1; 
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not Possible");
            return;
        }

        System.out.println("Enter " + n + " node values:");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        System.out.print("Enter value to search: ");
        int target = sc.nextInt();

        System.out.println("Linked list:");
        printList(head);

        int position = searchNode(head, target);

        if (position != -1)
            System.out.println("Value " + target + " found at index " + position + ".");
        else
            System.out.println("Value " + target + " not found in the list.");

        sc.close();
    }
}
