import java.util.*;

public class StockSpanProgram {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();  
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stock prices: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter the stock prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] span = calculateSpan(prices);

        System.out.println("Stock Span for each day:");
        for (int i = 0; i < n; i++) {
            System.out.println(prices[i] + " -> " + span[i]);
        }

        sc.close();
    }
}
