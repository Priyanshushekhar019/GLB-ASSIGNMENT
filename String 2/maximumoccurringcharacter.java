import java.util.*;
public class maximumoccurringcharacter {
    static void maxOccurringCharacter(String str){
        int[] freq=new int[26];
        str=str.toLowerCase();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c>='a' && c<='z'){
                freq[c-'a']++;
            }
        }
        int max=-1;
        char maxchar='a';
        for(int i=0;i<26;i++){
            if(freq[i]>max){
                max=freq[i];
                maxchar=(char)(i+'a');
            }
        }
        System.out.println("Maximum occurring character:"+maxchar);
        System.out.println("Frequency:"+max);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String str=sc.nextLine();
        maxOccurringCharacter(str);
    }
}
