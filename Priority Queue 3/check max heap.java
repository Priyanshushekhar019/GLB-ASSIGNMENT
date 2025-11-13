import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class checkmaxheap {
    public static int countNodes(Node root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static boolean isMaxHeap(Node root, int index, int totalNodes) {
        if (root == null)
            return true;
        if (index >= totalNodes)
            return false;
        if (root.left != null && root.data < root.left.data)
            return false;
        if (root.right != null && root.data < root.right.data)
            return false;
        return isMaxHeap(root.left, 2 * index + 1, totalNodes)
                && isMaxHeap(root.right, 2 * index + 2, totalNodes);
    }
    public static Node buildTreeLevelOrder(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null)
            return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();
            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the tree in level order:");
        String[] parts = sc.nextLine().trim().split("\\s+");
        Integer[] arr = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            int val = Integer.parseInt(parts[i]);
            arr[i] = (val == -1) ? null : val;
        }

        Node root = buildTreeLevelOrder(arr);
        int totalNodes = countNodes(root);

        boolean result = isMaxHeap(root, 0, totalNodes);

        if (result)
            System.out.println("The given binary tree is a Max Heap.");
        else
            System.out.println("The given binary tree is NOT a Max Heap.");

        sc.close();
    }
}
