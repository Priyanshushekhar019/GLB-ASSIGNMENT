import java.util.*;

public class validanagram{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine().toLowerCase();

        System.out.print("Enter second string: ");
        String t = sc.nextLine().toLowerCase();

        if (s.length() != t.length()) {
            System.out.println("Not an anagram");
            sc.close();
            return;
        }

        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!freq.containsKey(ch)) {
                System.out.println("Not an anagram");
                sc.close();
                return;
            }
            freq.put(ch, freq.get(ch) - 1);
        }
        for (int count : freq.values()) {
            if (count != 0) {
                System.out.println("Not an anagram");
                sc.close();
                return;
            }
        }
        System.out.println("The two strings are valid anagrams.");
        sc.close();
    }
}
