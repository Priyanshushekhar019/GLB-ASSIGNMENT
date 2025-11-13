import java.util.*;

public class longestconsecutivesequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }

        int longestStreak = 0;

        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (map.containsKey(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        System.out.println("Length of the longest consecutive sequence: " + longestStreak);

        sc.close();
    }
}

