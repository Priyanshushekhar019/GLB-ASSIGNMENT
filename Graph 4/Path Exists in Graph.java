import java.util.*;

public class PathExistsInGraph {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges:");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        System.out.print("Enter source: ");
        int source = sc.nextInt();

        System.out.print("Enter destination: ");
        int destination = sc.nextInt();

        boolean[] visited = new boolean[n];
        boolean result = dfs(source, destination, adj, visited);

        System.out.println("Path exists? " + result);

        sc.close();
    }

    public static boolean dfs(int node, int dest, 
                              List<List<Integer>> adj, boolean[] visited) {
        if (node == dest) return true;

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, dest, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
