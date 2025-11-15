import java.util.*;

public class CountingBits{

    public static int countSetBits(int x) {
        int count = 0;
        while (x > 0) {
            x &= (x - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Counting bits for numbers 0 to " + n + ":");

        for (int i = 0; i <= n; i++) {
            System.out.println(i + " -> " + countSetBits(i));
        }

        sc.close();
    }
}
