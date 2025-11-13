import java.util.*;

public class zerosumsubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int sum = 0; 
        boolean found = false;

        System.out.println("Zero-sum subarrays:");

        for (int i = 0; i < n; i++) {
            sum += arr[i];

           
            if (sum == 0) {
                System.out.println("Subarray found from Index 0 to " + i);
                found = true;
            }

            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                for (int start : list) {
                    System.out.println("Subarray found from Index " + (start + 1) + " to " + i);
                    found = true;
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        if (!found) {
            System.out.println("No subarray with zero sum found");
        }

        sc.close();
    }
}
