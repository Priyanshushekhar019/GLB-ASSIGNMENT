import java.util.*;

public class CheckKthBit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        boolean isSet = (num & (1 << k)) != 0;

        System.out.println(isSet);

        sc.close();
    }
}
