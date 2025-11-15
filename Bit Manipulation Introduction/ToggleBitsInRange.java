import java.util.*;

public class ToggleBitsInRange {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.print("Enter starting bit position: ");
        int L = sc.nextInt();

        System.out.print("Enter ending bit position: ");
        int R = sc.nextInt();
        int mask = ((1 << (R - L + 1)) - 1) << L;
        int result = num ^ mask;

        System.out.println("Original number: " + num);
        System.out.println("Original binary: " + Integer.toBinaryString(num));

        System.out.println("Mask: " + Integer.toBinaryString(mask));
        
        System.out.println("Result after toggling bits: " + result);
        System.out.println("Result binary: " + Integer.toBinaryString(result));
    }
}
