import java.util.*;

public class BreadthFirstSearch {

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

        System.out.print("Enter starting node for BFS: ");
        int start = sc.nextInt();

        System.out.println("\nBFS Traversal:");
        bfs(start, adj, V);

        sc.close();
    }

    public static void bfs(int start, List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }
}
