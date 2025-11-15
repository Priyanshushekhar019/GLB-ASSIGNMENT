import java.util.*;

public class GenerateParenthesis{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        List<String> result = generateParenthesis(n);

        System.out.println("All valid parentheses combinations:");
        for (String s : result) {
            System.out.println(s);
        }

        sc.close();
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current,
                                  int open, int close, int max) {

        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
