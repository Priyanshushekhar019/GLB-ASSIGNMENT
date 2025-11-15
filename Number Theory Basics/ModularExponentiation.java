import java.util.*;

public class ModularExponentiation {

    public static int modPow(int a, int k, int mod) {
        int result = 1;
        a %= mod;

        while (k > 0) {
            if ((k & 1) == 1)
                result = (result * a) % mod;

            a = (a * a) % mod;
            k >>= 1;
        }

        return result;
    }

    public static int superPow(int a, List<Integer> b) {
        if (b.isEmpty()) return 1;

        int lastDigit = b.remove(b.size() - 1);

        int part1 = modPow(superPow(a, b), 10, 1337);
        int part2 = modPow(a, lastDigit, 1337);

        return (part1 * part2) % 1337;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of a: ");
        int a = sc.nextInt();

        System.out.print("Enter size of array b: ");
        int n = sc.nextInt();

        List<Integer> b = new ArrayList<>();

        System.out.println("Enter " + n + " digits of b:");
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt());
        }
        int result = superPow(a, new ArrayList<>(b));

        System.out.println("Result = " + result);

        sc.close();
    }
}
