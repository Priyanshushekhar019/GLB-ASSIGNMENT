import java.util.*;

public class MaxChunksToMakeSorted2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = maxChunksToSorted(arr);
        System.out.println("Maximum chunks = " + result);

        sc.close();
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> freq = new HashMap<>();
        int chunks = 0;

        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            freq.put(sorted[i], freq.getOrDefault(sorted[i], 0) - 1);

            if (freq.get(arr[i]) == 0) freq.remove(arr[i]);
            if (freq.containsKey(sorted[i]) && freq.get(sorted[i]) == 0) freq.remove(sorted[i]);

            if (freq.isEmpty()) {
                chunks++;
            }
        }

        return chunks;
    }
}
