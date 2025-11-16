import java.util.*;

public class AllPathsSourceTarget {

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes in graph: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number of neighbours of node " + i + ": ");
            int m = sc.nextInt();
            graph[i] = new int[m];

            System.out.println("Enter the neighbours of node " + i + ": ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        path.add(0);
        dfs(0, graph, n - 1);

        System.out.println("All Paths from 0 to " + (n - 1) + ":");
        for (List<Integer> p : result) {
            System.out.println(p);
        }

        sc.close();
    }

    public static void dfs(int node, int[][] graph, int target) {
        if (node == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int next : graph[node]) {
            path.add(next);
            dfs(next, graph, target);
            path.remove(path.size() - 1); 
        }
    }
}
