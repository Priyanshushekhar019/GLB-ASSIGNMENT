import java.util.*;
public class repeatingelementinarray {
    static void findelements(int[] arr){
        int count=0;
        int[] duplicates=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    duplicates[count]=arr[i];
                    count++;
                    break;
                }
            }
        }
        System.out.println("The elements are:");
        for(int i=0;i<count;i++){
            System.out.print(duplicates[i]+" ");
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
        findelements(arr);
    }
}
