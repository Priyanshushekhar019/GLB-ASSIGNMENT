import java.util.*;

public class removeduplicatesfromsortedLL{
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
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

        System.out.println("Original List:");
        printList(head);
        head = deleteDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);

        sc.close();
    }
}
