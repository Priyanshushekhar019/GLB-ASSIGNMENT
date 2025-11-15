import java.util.*;

public class combinations{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        List<List<Integer>> result = combine(n, k);

        System.out.println("All combinations:");
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }

        sc.close();
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {

        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);                   
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }
}
