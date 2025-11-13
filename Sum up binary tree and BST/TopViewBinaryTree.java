import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Pair {
    TreeNode node;
    int hd;

    Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewBinaryTree {
    public static void printTopView(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int hd = current.hd;
            TreeNode node = current.node;

            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.val);
            }
            if (node.left != null)
                queue.add(new Pair(node.left, hd - 1));

            if (node.right != null)
                queue.add(new Pair(node.right, hd + 1));
        }

        System.out.println("Top View of the Binary Tree:");
        for (int value : topViewMap.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
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
        printTopView(root);

        sc.close();
    }
}
