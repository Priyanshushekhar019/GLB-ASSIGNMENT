import java.util.*;

public class UpperBound {

    public static int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
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
        System.out.println("Enter elements (sorted):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter value to find upper bound of: ");
        int x = sc.nextInt();

        int index = upperBound(arr, x);

        if (index == n) {
            System.out.println("Upper bound index: " + index + " (No element > " + x + ")");
        } else {
            System.out.println("Upper bound index: " + index);
            System.out.println("Element at upper bound: " + arr[index]);
        }

        sc.close();
    }
}
