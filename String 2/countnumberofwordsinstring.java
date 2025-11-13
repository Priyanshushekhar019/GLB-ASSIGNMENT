import java.util.*;
public class countnumberofwordsinstring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String str=sc.nextLine();
        int space=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                space=space+1;
            }
        }
        System.out.println("Number of words in the string:"+(space+1));
    }
}
