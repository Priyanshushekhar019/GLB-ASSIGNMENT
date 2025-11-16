import java.util.*;

public class MinimumPlatforms {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of trains: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] dep = new int[n];

        System.out.println("Enter arrival times:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter departure times:");
        for (int i = 0; i < n; i++) {
            dep[i] = sc.nextInt();
        }

        int result = findMinPlatforms(arr, dep);
        System.out.println("Minimum number of platforms required = " + result);

        sc.close();
    }

    public static int findMinPlatforms(int[] arr, int[] dep) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int platforms = 0;
        int maxPlatforms = 0;

        while (i < arr.length && j < dep.length) {

            if (arr[i] <= dep[j]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } else {
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }
}
