import java.util.*;

public class combinationsum2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] candidates = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        List<List<Integer>> result = combinationSum2(candidates, target);

        System.out.println("All unique combinations:");
        for (List<Integer> list : result) {
            System.out.println(list);
        }

        sc.close();
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int[] nums, int target,
                                  List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) continue;

            if (nums[i] > target) break;

            current.add(nums[i]);
            backtrack(i + 1, nums, target - nums[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
