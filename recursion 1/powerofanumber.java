import java.math.BigInteger;
import java.util.*;
public class powerofanumber {
    static int reverse(int n,int rev){
        if(n==0){
            return rev;
        }
        return reverse(n/10,rev*10+n%10);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int n=sc.nextInt();
        int rev=reverse(n,0);
        BigInteger base=BigInteger.valueOf(n);
        BigInteger result=base.pow(rev);
        System.out.println("Reverse of "+n+" is:"+rev);
        System.out.println(n+" raised to the power "+rev+" is:");
        System.out.println(result);
    }
}
