import java.util.Scanner;

public class intersectionoftwosets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of first array:");
        int n1=sc.nextInt();
        int[] arr1=new int[n1];
        System.out.println("Enter the elements of first array:");
        for(int i=0;i<n1;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.println("Enter the size of second array:");
        int n2=sc.nextInt();
        int[] arr2=new int[n2];
        System.out.println("Enter the elements of second array:");
        for(int i=0;i<n2;i++){
            arr2[i]=sc.nextInt();
        }
        System.out.println("Intersection:");
        boolean[] visited=new boolean[n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(arr1[i]==arr2[j] && !visited[j]){
                    System.out.print(arr1[i]+" ");
                    visited[j]=true;
                    break;
                }
            }
        }
    }
}
