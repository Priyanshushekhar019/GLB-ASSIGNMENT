import java.util.*;

public class mergetwoLL{
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
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
        System.out.print("Enter number of nodes in List 1: ");
        int n1 = sc.nextInt();
        ListNode l1 = null, tail1 = null;

        if (n1 > 0) {
            System.out.println("Enter " + n1 + " sorted values for List 1:");
            l1 = new ListNode(sc.nextInt());
            tail1 = l1;
            for (int i = 1; i < n1; i++) {
                tail1.next = new ListNode(sc.nextInt());
                tail1 = tail1.next;
            }
        }

        System.out.print("Enter number of nodes in List 2: ");
        int n2 = sc.nextInt();
        ListNode l2 = null, tail2 = null;

        if (n2 > 0) {
            System.out.println("Enter " + n2 + " sorted values for List 2:");
            l2 = new ListNode(sc.nextInt());
            tail2 = l2;
            for (int i = 1; i < n2; i++) {
                tail2.next = new ListNode(sc.nextInt());
                tail2 = tail2.next;
            }
        }

        System.out.println("List 1:");
        printList(l1);
        System.out.println("List 2:");
        printList(l2);
        ListNode merged = mergeTwoLists(l1, l2);
        System.out.println("Merged Sorted List:");
        printList(merged);

        sc.close();
    }
}
