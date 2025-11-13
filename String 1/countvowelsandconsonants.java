import java.util.*;
public class countvowelsandconsonants {
    static void counting(String str,int length){
        int vowels=0;
        int consonants=0;
        int whitespaces=0;
        str=str.toLowerCase();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vowels++;
            }else if(ch>='a' && ch<='z'){
                consonants++;
            }
            else{
                whitespaces++;
            }
        }
        System.out.println("Vowels:"+vowels);
        System.out.println("Consonants:"+consonants);
        System.out.println("Whitespaces:"+whitespaces);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String str=sc.nextLine();
        int length=str.length();
        counting(str,length);
    }
}
