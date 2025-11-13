import java.util.*;

public class maximumsubarrayproduct {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int minproduct=arr[0];
        int maxproduct=arr[0];
        int result=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]<0){
                int temp=minproduct;
                minproduct=maxproduct;
                maxproduct=temp;
            }
            maxproduct=Math.max(arr[i],maxproduct*arr[i]);
            minproduct=Math.min(arr[i],minproduct*arr[i]);
            result=Math.max(result,maxproduct);
        }
        System.out.println("Maximum product subarray:"+result);
    }
}
