import java.util.*;

public class countnodeinLL{

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public static int countNodes(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
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

        System.out.println("Linked list:");
        printList(head);

        int totalNodes = countNodes(head);
        System.out.println("Total number of nodes: " + totalNodes);

        sc.close();
    }
}
