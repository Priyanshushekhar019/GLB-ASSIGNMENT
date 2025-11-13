import java.util.*;
public class leftrightrotatearraybykposition {
    static void reverse(int[] arr,int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    static void rightrotation(int[] arr,int k){
        int n=arr.length;
        k=k%n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
    }
    static void leftrotation(int[] arr,int k){
        int n=arr.length;
        k=k%n;
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the no. of rotations:");
        int k1=sc.nextInt();
        int[] leftArray=arr.clone();
        int[] rightArray=arr.clone();
        leftrotation(leftArray, k1);
        rightrotation(rightArray, k1);
        System.out.println("Left rotated:"+Arrays.toString(leftArray));
        System.out.println("Right rotated:"+Arrays.toString(rightArray));

    }
}
