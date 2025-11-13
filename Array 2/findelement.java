import java.util.*;
public class findelementinanarray {
    static int findelement(int[] arr,int n, int key){
        for(int i=0;i<n;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
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
        System.out.println("Enter the key:");
        int key=sc.nextInt();
        int pos=findelement(arr,n,key);
        if(pos==-1){
            System.out.println("Element not found in the array");
        }
        else{
            System.out.println("Element found at index: "+(pos+1));
        }
}
}
