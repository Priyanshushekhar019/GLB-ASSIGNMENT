import java.util.*;

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt(); // max pile size

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1; 
            }
        }

        return left;
    }

    private static boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;

        for (int p : piles) {
            hours += (p + speed - 1) / speed; 
        }

        return hours <= h;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of piles: ");
        int n = sc.nextInt();

        int[] piles = new int[n];
        System.out.println("Enter banana piles:");

        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        System.out.print("Enter number of hours (H): ");
        int h = sc.nextInt();

        int result = minEatingSpeed(piles, h);

        System.out.println("Minimum eating speed K: " + result);

        sc.close();
    }
}
