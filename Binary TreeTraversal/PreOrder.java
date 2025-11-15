import java.util.*;

public class PreOrder{

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
    public static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);       
        preorder(root.left, result); 
        preorder(root.right, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter level order of the tree:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeNode root = buildTree(arr);

        List<Integer> preorderList = new ArrayList<>();
        preorder(root, preorderList);

        System.out.println("Preorder Traversal:");
        for (int v : preorderList) {
            System.out.print(v + " ");
        }
        System.out.println();

        sc.close();
    }
}

