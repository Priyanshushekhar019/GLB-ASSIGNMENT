import java.util.*;

public class ImplementationOfBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    static class BST {
        TreeNode root;
        public void insert(int val) {
            root = insertRec(root, val);
        }

        private TreeNode insertRec(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);

            if (val < root.val)
                root.left = insertRec(root.left, val);
            else if (val > root.val)
                root.right = insertRec(root.right, val);

            return root;
        }

        public boolean search(int val) {
            return searchRec(root, val);
        }

        private boolean searchRec(TreeNode root, int val) {
            if (root == null) return false;
            if (root.val == val) return true;

            if (val < root.val)
                return searchRec(root.left, val);
            else
                return searchRec(root.right, val);
        }
        public void delete(int val) {
            root = deleteRec(root, val);
        }

        private TreeNode deleteRec(TreeNode root, int key) {
            if (root == null) return null;

            if (key < root.val)
                root.left = deleteRec(root.left, key);
            else if (key > root.val)
                root.right = deleteRec(root.right, key);
            else {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                root.val = minValue(root.right);
                root.right = deleteRec(root.right, root.val);
            }
            return root;
        }

        private int minValue(TreeNode root) {
            while (root.left != null) root = root.left;
            return root.val;
        }

        public void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }

        public void preorder(TreeNode root) {
            if (root == null) return;
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public void postorder(TreeNode root) {
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();

        while (true) {
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    bst.insert(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value to search: ");
                    System.out.println("Found? " + bst.search(sc.nextInt()));
                    break;

                case 3:
                    System.out.print("Enter value to delete: ");
                    bst.delete(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Inorder: ");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Preorder: ");
                    bst.preorder(bst.root);
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Postorder: ");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Exiting");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
