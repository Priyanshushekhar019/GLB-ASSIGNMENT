import java.util.*;

public class SingleNumber1 {

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n; 
        }
        return xor;
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

        int result = singleNumber(nums);

        System.out.println("Single Number = " + result);

        sc.close();
    }
}
