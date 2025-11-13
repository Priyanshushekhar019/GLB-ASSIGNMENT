import java.util.*;
public class frequencyofacharacter {
    static void printFrequency(String str){
        int[] freq=new int[26];
        str=str.toLowerCase();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c>='a'&& c<='z'){
                freq[c-'a']++;
            }
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                System.out.println((char)(i+'a') + ": " + freq[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String str=sc.nextLine();
        printFrequency(str);
    }
}
