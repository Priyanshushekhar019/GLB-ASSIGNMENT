import java.util.*;

public class contiguousarray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in the binary array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " binary elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        int sum = 0;  
        int maxLen = 0;

        
        for (int i = 0; i < n; i++) {
           
            sum += (nums[i] == 1) ? 1 : -1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        System.out.println("Maximum length of contiguous subarray with equal 0s and 1s: " + maxLen);

        sc.close();
    }
}
