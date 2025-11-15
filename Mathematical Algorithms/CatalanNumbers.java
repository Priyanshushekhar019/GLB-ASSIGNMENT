import java.util.*;

public class CatalanNumbers{

    public static int numTrees(int n) {
        if (n <= 1) return 1;

        int total = 0;

        for (int root = 1; root <= n; root++) {
            int left = numTrees(root - 1);     
            int right = numTrees(n - root);   
            total += left * right;
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int result = numTrees(n);

        System.out.println("Number of unique BSTs with " + n + " nodes = " + result);

        sc.close();
    }
}
