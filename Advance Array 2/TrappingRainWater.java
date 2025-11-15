import java.util.*;

public class TrappingRainWater{

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {

            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bars: ");
        int n = sc.nextInt();

        int[] height = new int[n];
        System.out.println("Enter heights of bars:");

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int result = trap(height);

        System.out.println("Total Trapped Water = " + result);

        sc.close();
    }
}
