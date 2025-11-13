import java.util.Scanner;

public class countdigit {
    static int countDividingDigits(int n){
        int original=n;
        int count=0;
        while(n!=0){
            int digit=n%10;
            if(digit!=0 && original%digit==0){
                count++;
            }
            n=n/10;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int num=sc.nextInt();
        int result=countDividingDigits(num);
        System.out.println("Count of digits that divide "+num+" evenly:"+result);

    }
}
