import java.util.Scanner;

public class towerofhanoirec {
    static long towerofhanoi(int n){
        if(n==0){
            return 0;
        }
        return 2*towerofhanoi(n-1)+1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of disks:");
        int n=sc.nextInt();
        long moves=towerofhanoi(n);
        System.out.println("Minimum no. of moves required:"+moves);
    }
}
