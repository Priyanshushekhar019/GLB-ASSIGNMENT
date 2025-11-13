import java.util.*;

public class longestsubstringwithoutrepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0; 
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            map.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println("Length of the longest substring without repeating: " + maxLength);

        sc.close();
    }
}
