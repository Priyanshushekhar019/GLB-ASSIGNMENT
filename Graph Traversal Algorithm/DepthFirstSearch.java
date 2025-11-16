import java.util.*;

public class DepthFirstSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Is the graph directed? (yes/no): ");
        String directed = sc.next().toLowerCase();

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);

            if (directed.equals("no")) {
                adj.get(v).add(u);
            }
        }

        System.out.print("Enter starting node for DFS: ");
        int start = sc.nextInt();

        boolean[] visited = new boolean[V];

        System.out.println("DFS Traversal:");
        dfs(start, adj, visited);

        sc.close();
    }

    public static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
