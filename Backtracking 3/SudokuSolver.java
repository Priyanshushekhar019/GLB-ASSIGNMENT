import java.util.*;

public class SudokuSolver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        System.out.println("Enter the Sudoku board:");

        for (int i = 0; i < 9; i++) {
            String row = sc.next();
            for (int j = 0; j < 9; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        solveSudoku(board);

        System.out.println("Solved Sudoku:");
        for (char[] r : board) {
            System.out.println(Arrays.toString(r));
        }

        sc.close();
    }

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, r, c, ch)) {

                            board[r][c] = ch;

                            if (solve(board)) return true;

                            board[r][c] = '.'; 
                        }
                    }

                    return false;
                }
            }
        }
        return true; 
    }

    private static boolean isValid(char[][] board, int row, int col, char num) {
        
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == num) return false;
        }

        for (int r = 0; r < 9; r++) {
            if (board[r][col] == num) return false;
        }

        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (board[r][c] == num) return false;
            }
        }

        return true;
    }
}
