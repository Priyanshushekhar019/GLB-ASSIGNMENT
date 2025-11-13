import java.util.*;
public class countelementswithmaximumfrequency {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] arr=new int[n]; 
        System.out.println("Enter the elements of array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int count=1;
        int maxfreq=1;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]){
                count++;
            }
            else{
                count=1;
            }
        }
        if(count>maxfreq){
            maxfreq=count;
        }
        System.out.println("Maximum frequency:"+maxfreq);
    }
}
