import java.util.*;
public class equilibriumelementinarray {
    static int pivotIndex(int[] nums){
        int totalsum=0;
        for(int num:nums){
            totalsum+=num;
        }
        int leftsum=0;
        for(int i=0;i<nums.length;i++){
            if(leftsum==totalsum-leftsum-nums[i]){
                return i;
            }
            leftsum+=nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the elements of array:"); 
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int res=pivotIndex(nums);
        System.out.println("Index:"+res);
    }
}
