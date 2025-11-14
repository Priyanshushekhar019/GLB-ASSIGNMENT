import java.util.*;

public class addtwonumberinLL{
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

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
        System.out.print("Enter number of digits in first number: ");
        int n1 = sc.nextInt();
        ListNode l1 = null, tail1 = null;

        System.out.println("Enter the digits in reverse order:");
        for (int i = 0; i < n1; i++) {
            int val = sc.nextInt();
            if (l1 == null) {
                l1 = new ListNode(val);
                tail1 = l1;
            } else {
                tail1.next = new ListNode(val);
                tail1 = tail1.next;
            }
        }
        System.out.print("Enter number of digits in second number: ");
        int n2 = sc.nextInt();
        ListNode l2 = null, tail2 = null;

        System.out.println("Enter the digits in reverse order:");
        for (int i = 0; i < n2; i++) {
            int val = sc.nextInt();
            if (l2 == null) {
                l2 = new ListNode(val);
                tail2 = l2;
            } else {
                tail2.next = new ListNode(val);
                tail2 = tail2.next;
            }
        }
        System.out.println("First Number:");
        printList(l1);
        System.out.println("Second Number:");
        printList(l2);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println("Sum:");
        printList(result);

        sc.close();
    }
}
