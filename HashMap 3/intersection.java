import java.util.*;

public class intersectionoftwoarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter " + n1 + " elements of first array:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter " + n2 + " elements of second array:");
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, true);
        }

        HashSet<Integer> intersection = new HashSet<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                intersection.add(num);
            }
        }

        if (intersection.isEmpty()) {
            System.out.println("No intersection between the two arrays.");
        } else {
            System.out.println("Intersection of the two arrays:");
            for (int num : intersection) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
