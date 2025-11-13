import java.util.*;
public class runningsumof1darray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=1;i<n;i++){
            arr[i]=arr[i]+arr[i-1];
        }
        System.out.println("Sum:"+Arrays.toString(arr));
    }
}
