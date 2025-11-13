import java.util.*;
public class removecharacterexceptalphabet {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String s=sc.nextLine();
        StringBuilder res=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c>='A' && c<='Z' || c>='a' && c<='z'){
                res.append(c);
            }
        }
        System.out.println("String after removing non-alphabets:"+res);
    }
}
