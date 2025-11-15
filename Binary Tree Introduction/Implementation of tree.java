import java.util.*;

public class ImplementationOfTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {

        TreeNode[] nodes = new TreeNode[100001];
        boolean[] isChild = new boolean[100001];

        for (int[] d : descriptions) {
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];

            if (nodes[parent] == null)
                nodes[parent] = new TreeNode(parent);

            if (nodes[child] == null)
                nodes[child] = new TreeNode(child);

            if (isLeft == 1)
                nodes[parent].left = nodes[child];
            else
                nodes[parent].right = nodes[child];

            isChild[child] = true;
        }
        for (int[] d : descriptions) {
            int parent = d[0];
            if (!isChild[parent])
                return nodes[parent];
        }

        return null;
    }
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        System.out.println("Level Order Traversal:");
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of descriptions: ");
        int n = sc.nextInt();

        int[][] descriptions = new int[n][3];

        System.out.println("Enter parent child isLeft:");
        for (int i = 0; i < n; i++) {
            descriptions[i][0] = sc.nextInt();
            descriptions[i][1] = sc.nextInt();
            descriptions[i][2] = sc.nextInt();
        }

        TreeNode root = createBinaryTree(descriptions);

        System.out.println("Root of Tree: " + root.val);

        printTree(root);

        sc.close();
    }
}
