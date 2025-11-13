import java.util.*;
public class stringispalindromeornot {
    static boolean isPalindrome(String s){
        s=s.toLowerCase();
        StringBuilder clean=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                clean.append(c);
            }
        } 
        int left=0;
        int right=clean.length()-1;
        while(left<right){
            if(clean.charAt(left)!=clean.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String input=sc.nextLine();
        if(isPalindrome(input)){
            System.out.println("The string is a palindrome.");
        }else{
            System.out.println("The string is not a palindrome.");
        }
    }
}
