import java.util.*;

public class printingelementsinsortedorder {

    static int[] sortArray(int[] nums){
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    static void mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid = left + (right-left)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    static void merge(int[] arr,int left,int mid,int right){
        int n1 = mid-left+1;
        int n2 = right-mid;

        int[] a = new int[n1];
        int[] b = new int[n2];

        for(int i=0;i<n1;i++){
            a[i] = arr[left+i];
        }
        for(int j=0;j<n2;j++){
            b[j] = arr[mid+1+j];
        }

        int i=0, j=0, k=left;

        while(i<n1 && j<n2){
            if(a[i] <= b[j]){
                arr[k++] = a[i++];
            } else {
                arr[k++] = b[j++];
            }
        }

        while(i < n1){
            arr[k++] = a[i++];
        }

        while(j < n2){
            arr[k++] = b[j++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        int[] res = sortArray(nums);

        System.out.println("Sorted array:");
        for(int k : res){
            System.out.print(k + " ");
        }
    }
}
