import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coin types: ");
        int n = sc.nextInt();

        int[] coins = new int[n];
        System.out.println("Enter coin values:");
        for (int i = 0; i < n; i++) coins[i] = sc.nextInt();

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        int result = coinChangeGreedy(coins, amount);
        System.out.println("Greedy result = " + result);

        sc.close();
    }

    public static int coinChangeGreedy(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }

        return amount == 0 ? count : -1;
    }
}
