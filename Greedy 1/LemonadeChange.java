import java.util.*;

public class LemonadeChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();

        int[] bills = new int[n];
        System.out.println("Enter the bills given by customers:");
        for (int i = 0; i < n; i++) {
            bills[i] = sc.nextInt();
        }

        boolean result = lemonadeChange(bills);
        System.out.println(result);

        sc.close();
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {

            if(bill == 5) {
                five++;
            } 
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } 
            else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } 
                else if (five >= 3) {
                    five -= 3;
                } 
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
