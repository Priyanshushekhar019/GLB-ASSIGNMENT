import java.util.*;

public class LowerBound {

    public static int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < x) {
                low = mid + 1;   
            } else {
                high = mid;      
            }
        }
        return low;  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter value to find lower bound of: ");
        int x = sc.nextInt();

        int index = lowerBound(arr, x);

        if (index == n) {
            System.out.println("Lower bound index: " + index + " (No element >= " + x + ")");
        } else {
            System.out.println("Lower bound index: " + index);
            System.out.println("Element at lower bound: " + arr[index]);
        }

        sc.close();
    }
}
