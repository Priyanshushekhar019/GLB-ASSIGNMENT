import java.util.*;

public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the permutation elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = maxChunksToSorted(arr);
        System.out.println("Maximum chunks = " + result);

        sc.close();
    }

    public static int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);

            if (maxSoFar == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
