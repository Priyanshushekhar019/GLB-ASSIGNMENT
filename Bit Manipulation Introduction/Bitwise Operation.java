import java.util.*;

public class BitwiseOperations {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter first number: ");
    int num1 = sc.nextInt();
    System.out.print("Enter second number: ");
    int num2 = sc.nextInt();
        int andRes = num1 & num2;
        int orRes = num1 | num2;
        int xorRes = num1 ^ num2;
        System.out.println("AND  (num1 & num2) = " + andRes);
        System.out.println("OR   (num1 | num2) = " + orRes);
        System.out.println("XOR  (num1 ^ num2) = " + xorRes);
       
        System.out.println("num1: " + Integer.toBinaryString(num1));
        System.out.println("num2: " + Integer.toBinaryString(num2));
        System.out.println("AND : " + Integer.toBinaryString(andRes));
        System.out.println("OR  : " + Integer.toBinaryString(orRes));
        System.out.println("XOR : " + Integer.toBinaryString(xorRes));
    }
}
