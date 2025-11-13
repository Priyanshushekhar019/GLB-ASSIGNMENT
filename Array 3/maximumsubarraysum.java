import java.util.*;
public class maximumsubarraysum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        int[] arr=new int[n];   
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int csum=0;
        int msum=0;
        for(int i=1;i<n;i++){
            csum=Math.max(arr[i],csum+arr[i]);
            msum=Math.max(msum,csum);
        }
        System.out.println("Maximum subarray sum:"+msum);
    }
}
