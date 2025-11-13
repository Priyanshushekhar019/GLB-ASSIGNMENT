import java.util.*;
public class removeminandmaxfromarray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] arr=new int[n]; 
        System.out.println("Enter the elements of array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();        
    }
    int minindex=0;
    int maxindex=0;
    for(int i=1;i<n;i++){
        if(arr[i]<arr[minindex]){
            minindex=i;
        }
        if(arr[i]>arr[maxindex]){
            maxindex=i;
        }
    }
    int left=Math.min(minindex,maxindex);
    int right=Math.max(minindex,maxindex);
    int o1=right+1;
    int o2=n-left;
    int o3=(left+1)+(n-right);
    int result=Math.min(o1,Math.min(o2,o3));
    System.out.println("Minimum deletion:" +result);

}
}
