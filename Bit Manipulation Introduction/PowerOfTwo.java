import java.util.*;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        boolean result = isPowerOfTwo(n);

        System.out.println(result);

        sc.close();
    }
}
