import java.util.Scanner;

public class ClosedIslands {

    static int n, m;
    static boolean dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;

        if (grid[r][c] == 1)
            return true;

        grid[r][c] = 1;

        boolean up = dfs(grid, r - 1, c);
        boolean down = dfs(grid, r + 1, c);
        boolean left = dfs(grid, r, c - 1);
        boolean right = dfs(grid, r, c + 1);

        return up && down && left && right;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter grid (0 = land, 1 = water):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int closedIslands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        closedIslands++;
                    }
                }
            }
        }

        System.out.println("Number of Closed Islands: " + closedIslands);

        sc.close();
    }
}
