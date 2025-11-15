import java.util.*;

public class PermutationOfString{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> result = permute(nums);

        System.out.println("All permutations:");
        for (List<Integer> p : result) {
            System.out.println(p);
        }

        sc.close();
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, boolean[] used,
                                  List<Integer> current, List<List<Integer>> result) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue; 

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, used, current, result);

            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
