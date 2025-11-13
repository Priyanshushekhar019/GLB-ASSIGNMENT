import java.util.*;

public class findallanagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int windowSize = p.length();
        while (right < s.length()) {
            char ch = s.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
            if (right - left + 1 > windowSize) {
                char leftChar = s.charAt(left);
                if (windowMap.get(leftChar) == 1) {
                    windowMap.remove(leftChar);
                } else {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                left++;
            }

            if (right - left + 1 == windowSize && windowMap.equals(pMap)) {
                result.add(left);
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the main string (s): ");
        String s = sc.nextLine();
        System.out.print("Enter the pattern string (p): ");
        String p = sc.nextLine();
        List<Integer> result = findAnagrams(s, p);

        System.out.println("Indices of anagrams of '" + p + "' in '" + s + "':");
        if (result.isEmpty()) {
            System.out.println("No anagrams found.");
        } else {
            for (int index : result) {
                System.out.print(index + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
