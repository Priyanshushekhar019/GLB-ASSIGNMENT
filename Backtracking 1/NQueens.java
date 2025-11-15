import java.util.*;

public class NQueens{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        List<List<String>> result = solveNQueens(n);

        System.out.println("Total Solutions = " + result.size());
        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }

        sc.close();
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] col = new boolean[n];         
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        backtrack(0, board, solutions, col, diag1, diag2, n);

        return solutions;
    }

    private static void backtrack(int row, char[][] board, List<List<String>> res,
                                  boolean[] col, boolean[] diag1, boolean[] diag2, int n) {

        if (row == n) {  
            res.add(construct(board));
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = row - c + (n - 1);
            int d2 = row + c;

            if (col[c] || diag1[d1] || diag2[d2]) continue;

            board[row][c] = 'Q';
            col[c] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, board, res, col, diag1, diag2, n);

         
            board[row][c] = '.';
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}

