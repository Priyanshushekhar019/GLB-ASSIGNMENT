import java.util.*;

public class SmallerElementOnLeft {

    public static int[] smallerOnLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ans = smallerOnLeft(arr);

        System.out.println("Next Smaller Element on the LEFT:");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " -> " + ans[i]);
        }

        sc.close();
    }
}
