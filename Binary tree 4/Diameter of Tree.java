import java.util.*;

public class DiameterofTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }
    public static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (i < arr.length) {
            TreeNode node = q.poll();
            if (i < arr.length && arr[i] != -1) {
                node.left = new TreeNode(arr[i]);
                q.offer(node.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                node.right = new TreeNode(arr[i]);
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }
    static int diameter = 0;
    public static int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);
        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter level order:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeNode root = buildTree(arr);

        int result = diameterOfBinaryTree(root);

        System.out.println("Diameter of the Binary Tree: " + result);

        sc.close();
    }
}
