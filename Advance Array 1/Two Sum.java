import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1}; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        int[] result = twoSum(nums, target);

        if (result[0] == -1) {
            System.out.println("No two numbers add up to the target.");
        } else {
            System.out.println("Indexes: " + result[0] + " , " + result[1]);
            System.out.println("Values: " + nums[result[0]] + " + " + nums[result[1]] + " = " + target);
        }

        sc.close();
    }
}
