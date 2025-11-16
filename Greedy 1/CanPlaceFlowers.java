import java.util.*;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of flowerbed: ");
        int n = sc.nextInt();

        int[] flowerbed = new int[n];
        System.out.println("Enter flowerbed array (0 or 1):");
        for (int i = 0; i < n; i++) {
            flowerbed[i] = sc.nextInt();
        }

        System.out.print("Enter number of flowers to place: ");
        int k = sc.nextInt();

        boolean result = canPlaceFlowers(flowerbed, k);
        System.out.println(result);

        sc.close();
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 0) {
                int left  = (i == 0) ? 0 : flowerbed[i - 1];
                int right = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];

                if (left == 0 && right == 0) {
                    flowerbed[i] = 1; 
                    count++;

                    if (count >= n) return true;
                }
            }
        }

        return count >= n;
    }
}
