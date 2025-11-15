import java.util.*;

public class combinationsum{

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

        List<List<Integer>> result = combinationSum(candidates, target);

        System.out.println("All possible combinations:");
        for (List<Integer> list : result) {
            System.out.println(list);
        }

        sc.close();
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int index, int[] nums, int target,
                                  List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index >= nums.length || target < 0) return;

        current.add(nums[index]);
        backtrack(index, nums, target - nums[index], current, result);
        current.remove(current.size() - 1);

        backtrack(index + 1, nums, target, current, result);
    }
}
