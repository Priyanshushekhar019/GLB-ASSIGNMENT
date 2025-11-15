import java.util.*;

public class InclusionExclusion{

    public static int inclusionExclusion2(int A, int B, int AB) {
        return A + B - AB;
    }

    public static int inclusionExclusion3(int A, int B, int C, int AB, int AC, int BC, int ABC) {
        return A + B + C - AB - AC - BC + ABC;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose number of sets(2 or 3): ");
        int sets = sc.nextInt();

        if (sets == 2) {
            System.out.print("Enter |A|: ");
            int A = sc.nextInt();

            System.out.print("Enter |B|: ");
            int B = sc.nextInt();

            System.out.print("Enter |A ∩ B|: ");
            int AB = sc.nextInt();

            int result = inclusionExclusion2(A, B, AB);
            System.out.println("A union B = " + result);

        } else if (sets == 3) {
            System.out.print("Enter |A|: ");
            int A = sc.nextInt();

            System.out.print("Enter |B|: ");
            int B = sc.nextInt();

            System.out.print("Enter |C|: ");
            int C = sc.nextInt();

            System.out.print("Enter |A ∩ B|: ");
            int AB = sc.nextInt();

            System.out.print("Enter |A ∩ C|: ");
            int AC = sc.nextInt();

            System.out.print("Enter |B ∩ C|: ");
            int BC = sc.nextInt();

            System.out.print("Enter |A ∩ B ∩ C|: ");
            int ABC = sc.nextInt();

            int result = inclusionExclusion3(A, B, C, AB, AC, BC, ABC);
            System.out.println("A union B union C = " + result);

        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
