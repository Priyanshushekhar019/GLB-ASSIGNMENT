import java.util.*;

public class EulerTotient{

    public static int phi(int n) {
        int result = n;

        for (int p = 2; p * p <= n; p++) {

            if (n % p == 0) {

                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }

        if (n > 1) {
            result -= result / n;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int phiValue = phi(n);
        System.out.println("Euler Totient φ(" + n + ") = " + phiValue);

        sc.close();
    }
}
