import java.util.*;

public class InOrder{

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

    public static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter level-order of tree:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeNode root = buildTree(arr);

        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        System.out.println("Inorder Traversal:");
        for (int v : inorderList) {
            System.out.print(v + " ");
        }
        System.out.println();

        sc.close();
    }
}
