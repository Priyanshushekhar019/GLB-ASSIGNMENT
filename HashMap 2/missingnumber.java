import java.util.*;

public class missingnumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of element:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " numbers from range [0, " + n + "]:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }

        int missing = -1;
        for (int i = 0; i <= n; i++) {  
            if (!map.containsKey(i)) {
                missing = i;
                break;
            }
        }

        if (missing == -1){
            System.out.println("No number is missing.");
        }
        else{
            System.out.println("Missing number is: " + missing);
        }
        sc.close();
    }
}
