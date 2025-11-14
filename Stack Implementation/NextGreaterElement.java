import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = nextGreaterElements(arr);
        System.out.println("Next Greater Elements:");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " -> " + result[i]);
        }

        sc.close();
    }

    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return nge;
    }
}
