import java.util.*;
public class reversingthearray{
    static void reverseafterposition(int[] arr,int pos){
        int start = pos + 1;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
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
        System.out.println("Enter the position:");
        int pos=sc.nextInt();
        reverseafterposition(arr,pos);
        System.out.println("After reversing the array:");
        System.out.println(Arrays.toString(arr));
    }
}
