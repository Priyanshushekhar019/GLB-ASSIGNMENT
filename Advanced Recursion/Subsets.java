import java.util.*;

public class Subsets{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> result = subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> list : result) {
            System.out.println(list);
        }

        sc.close();
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int[] nums,
                                  List<Integer> current, List<List<Integer>> result) {

        result.add(new ArrayList<>(current));  

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);             
            backtrack(i + 1, nums, current, result);  
            current.remove(current.size() - 1);
        }
    }
}
