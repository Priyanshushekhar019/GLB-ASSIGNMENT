import java.util.*;

public class DetectingCycleinGraph{

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

        System.out.println("Enter directed edges:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);       
        }

        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];
        boolean hasCycle = false;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recursionStack)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle present? " + hasCycle);

        sc.close();
    }
    public static boolean dfs(int node, List<List<Integer>> adj,
                              boolean[] visited, boolean[] recursionStack) {

        visited[node] = true;
        recursionStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, recursionStack)) {
                    return true;
                }
            }
            else if (recursionStack[neighbor]) {
                return true;
            }
        }
        recursionStack[node] = false;
        return false;
    }
}
