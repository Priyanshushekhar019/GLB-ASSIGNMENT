import java.util.*;

public class largestsubarraywithzerosum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;      
        int maxLen = 0;    

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxLen = i + 1;
            } else if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        System.out.println("Length of the largest subarray with zero sum: " + maxLen);

        sc.close();
    }
}
