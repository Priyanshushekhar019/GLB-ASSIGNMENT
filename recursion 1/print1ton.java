import java.util.*;
public class print1ton {
    static void printNumber(int curr,int n){
        if(curr>n){
            return;
        }
        System.out.print(curr+" ");
        printNumber(curr+1,n);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int n=sc.nextInt();
        printNumber(1,n);
    }
}
