import java.util.*;
public class removeduplicatefromstring {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String str=sc.nextLine();
        boolean[] seen=new boolean[256];
        StringBuilder res=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(!seen[c]){
                res.append(c);
                seen[c]=true;  
        }
        }
        System.out.println("String after removing duplicates:"+res);
}
}
