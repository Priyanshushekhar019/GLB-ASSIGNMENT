import java.util.*;

public class RatInMaze{

    private static final int LIMIT = (int) 1e6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of blocked cells: ");
        int b = sc.nextInt();

        int[][] blocked = new int[b][2];
        System.out.println("Enter blocked cells (row col):");
        for (int i = 0; i < b; i++) {
            blocked[i][0] = sc.nextInt();
            blocked[i][1] = sc.nextInt();
        }

        System.out.println("Enter source row and col:");
        int[] source = { sc.nextInt(), sc.nextInt() };

        System.out.println("Enter target row and col:");
        int[] target = { sc.nextInt(), sc.nextInt() };

        boolean result = isEscapePossible(blocked, source, target);

        System.out.println("Can escape: " + result);

        sc.close();
    }

    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> block = new HashSet<>();
        for (int[] b : blocked) {
            block.add(b[0] + "," + b[1]);
        }

        return dfsCheck(block, source, target) && dfsCheck(block, target, source);
    }
    public static boolean dfsCheck(Set<String> block, int[] start, int[] finish) {
        int maxArea = block.size() * block.size();   // ~40,000
        Set<String> visited = new HashSet<>();

        return dfs(start[0], start[1], finish, block, visited, maxArea);
    }

    public static boolean dfs(int r, int c, int[] finish, Set<String> block,
                              Set<String> visited, int maxArea) {

        if (visited.size() > maxArea) return true;
        if (r == finish[0] && c == finish[1]) return true;

        String key = r + "," + c;
        visited.add(key);

        int[][] dirs = { {1,0},{-1,0},{0,1},{0,-1} };

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= LIMIT || nc < 0 || nc >= LIMIT) continue;

            String nextKey = nr + "," + nc;

            if (block.contains(nextKey)) continue;
            if (visited.contains(nextKey)) continue;

            if (dfs(nr, nc, finish, block, visited, maxArea)) {
                return true;
            }
        }

        return false;
    }
}
