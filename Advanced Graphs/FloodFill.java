import java.util.Scanner;

public class FloodFill {

    static void floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return;
        fill(image, sr, sc, oldColor, newColor);
    }

    static void fill(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length)
            return;
        if (image[r][c] != oldColor)
            return;

        image[r][c] = newColor;

        fill(image, r - 1, c, oldColor, newColor); // up
        fill(image, r + 1, c, oldColor, newColor); // down
        fill(image, r, c - 1, oldColor, newColor); // left
        fill(image, r, c + 1, oldColor, newColor); // right
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] image = new int[n][m];

        System.out.println("Enter the image matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                image[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting row: ");
        int sr = sc.nextInt();

        System.out.print("Enter starting column: ");
        int scCol = sc.nextInt();

        System.out.print("Enter new color: ");
        int newColor = sc.nextInt();

        floodFill(image, sr, scCol, newColor);

        System.out.println("Updated Image:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
