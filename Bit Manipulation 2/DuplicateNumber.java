import java.util.*;

public class DuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int duplicate = 0;

        for (int bit = 0; bit < 32; bit++) {

            int mask = 1 << bit;

            int countArray = 0;    
            int countExpected = 0; 

            for (int num : nums) {
                if ((num & mask) != 0)
                    countArray++;
            }

            for (int i = 1; i < n; i++) {
                if ((i & mask) != 0)
                    countExpected++;
            }

            if (countArray > countExpected) {
                duplicate |= mask;
            }
        }

        return duplicate;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " numbers:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findDuplicate(nums);

        System.out.println("Duplicate number = " + result);

        sc.close();
    }
}
