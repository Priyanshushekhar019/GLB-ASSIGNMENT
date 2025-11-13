import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class sumofleaves {
    public static int sumofleaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        sum += sumofleaves(root.left);
        sum += sumofleaves(root.right);

        return sum;
    }
    public static TreeNode buildTreeLevelOrder(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
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
        TreeNode root = buildTreeLevelOrder(arr);
        int result = sumofleaves(root);
        System.out.println("\nSum of left leaves: " + result);

        sc.close();
    }
}
