import java.util.*;

public class slidingwindowmaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1] 
        );

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resIdx = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            if (i >= k - 1) {
                result[resIdx++] = pq.peek()[0];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter window size k: ");
        int k = sc.nextInt();
        int[] result = maxSlidingWindow(nums, k);

        System.out.println("Sliding Window Maximums:");
        for (int val : result) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
