import java.util.*;
public class removeduplicates {
    static String removedupli(String s,int index,boolean[] visited){
        if(index==s.length()){
            return "";
        }
        char c=s.charAt(i);
        if(!visited[c-'a']){
            visited[c-'a']=true;
            return c+removedupli(s,index+1,visited);
        }
        return removedupli(s,index+1,visited);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String s=sc.nextLine().toLowerCase();
        boolean[] visited=new boolean[26];
        String res=removedupli(s,0,visited);
        System.out.println("String after removing duplicates:"+res);
    }
}
