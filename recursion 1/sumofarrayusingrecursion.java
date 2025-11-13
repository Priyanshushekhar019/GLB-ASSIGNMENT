import java.util.*;
public class sumofarrayusingrecursion {
    static int sum(int[] array,int index){
        if(index==array.length){
            return 0;
        }
        return array[index]+sum(array,index+1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] array=new int[n];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        int result=sum(array,0);
        System.out.println("Sum of array:"+result);
            
        }
    }

