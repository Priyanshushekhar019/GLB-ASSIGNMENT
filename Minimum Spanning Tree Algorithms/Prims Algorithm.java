import java.util.Scanner;

public class PrimsAlgorithm {

    static int minKey(int[] key, boolean[] mstSet, int n) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (!mstSet[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void primMST(int[][] graph, int n) {
        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] mstSet = new boolean[n];

        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < n - 1; count++) {
            int u = minKey(key, mstSet, n);
            mstSet[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Edge Weight");
        int total = 0;
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            total += graph[i][parent[i]];
        }
        System.out.println("Total weight of MST: " + total);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        primMST(graph, n);

        sc.close();
    }
}
