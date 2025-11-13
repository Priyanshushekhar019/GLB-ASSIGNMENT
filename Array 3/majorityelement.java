import java.util.*;
public class majorityelement {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int res=majorelements(arr);
        System.out.println("Majority elements:"+res);
    }
    static int majorelements(int[] arr){
        int count=0;
        int candidate=0;
        for(int num:arr){
            if(count==0){
                candidate=arr[num];
            }
            if(num==candidate){
                count++;
            }
            else{
                count--;
            }
        }
        return candidate;
    }
}
