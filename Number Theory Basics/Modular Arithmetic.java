import java.util.*;

public class ModularArithmetic {

    public static int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;

        int remainder = 0;

        for (int length = 1; length <= K; length++) {
            remainder = (remainder * 10 + 1) % K;

            if (remainder == 0) return length;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter K: ");
        int K = sc.nextInt();

        int result = smallestRepunitDivByK(K);

        if (result == -1)
            System.out.println("No such number exists (K divisible by 2 or 5)");
        else
            System.out.println("Smallest length of repunit divisible by " + K + " = " + result);

        sc.close();
    }
}
