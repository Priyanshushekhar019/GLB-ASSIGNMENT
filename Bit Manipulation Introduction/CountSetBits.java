import java.util.*;

public class CountSetBits {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int count = 0;
        int n = num;

        while (n > 0) {
            count += (n & 1); 
            n >>= 1;          
        }

        System.out.println("Number of set bits in " + num + " = " + count);
    }
}
