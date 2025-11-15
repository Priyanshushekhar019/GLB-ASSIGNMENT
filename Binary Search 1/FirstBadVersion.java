import java.util.*;

public class FirstBadVersion {

    static int firstBad;
    public static boolean isBadVersion(int version) {
        return version >= firstBad;
    }

    public static int firstBadVersion(int n) {
        int low = 1, high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                high = mid;     
            } else {
                low = mid + 1; 
            }
        }
        return low; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of versions: ");
        int n = sc.nextInt();

        System.out.print("Enter the first bad version: ");
        firstBad = sc.nextInt();

        int ans = firstBadVersion(n);

        System.out.println("First Bad Version is: " + ans);

        sc.close();
    }
}
