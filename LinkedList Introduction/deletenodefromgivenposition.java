import java.util.*;

public class deletenodefromgivenposition {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 1) {
            System.out.println("Not Possible");
            return;
        }

        System.out.println("Enter " + n + " node values:");
        ListNode head = new ListNode(sc.nextInt());
        ListNode cur = head;
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(head);

        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
            nodes.add(cur);
        }

        System.out.print("Enter index of node to delete: ");
        int idx = sc.nextInt();

        if (idx < 0 || idx >= n - 1) {
            System.out.println("Invalid index! It must be between 0 and " + (n - 2));
            return;
        }

        System.out.println("\nOriginal list:");
        printList(head);

        // Perform deletion
        deleteNode(nodes.get(idx));

        System.out.println("List after deleting node at index " + idx + ":");
        printList(head);

        sc.close();
    }
}
