import java.util.*;
public class removeduplicatesfromsortedarray {
    static int removeduplicates(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
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

        int countObj=removeduplicates(nums);
        System.out.println("No. of unique elements:"+countObj);
        System.out.println("Array after removing duplicates:");
        for(int i=0;i<countObj;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
