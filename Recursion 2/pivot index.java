import java.util.*;
public class pivotindex {
    static int pivot(int[] nums){
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        return findpivot(nums,0,totalSum,0);
    }
    static int findpivot(int[] nums,int index,int total,int leftSum){
        if(index==nums.length){
            return -1;
        }
        int rightSum=total-leftSum-nums[index];
        if(leftSum==rightSum){
            return index;
        }
        return findpivot(nums, index+1, total, leftSum+nums[index]);
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
        int res=pivot(nums);
        System.out.println("Pivot Index:"+res);
    }
}
