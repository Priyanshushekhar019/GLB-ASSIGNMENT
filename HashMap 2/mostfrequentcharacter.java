import java.util.*;

public class mostfrequentcharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
        }

        int maxCount = 0;
        for (int count : freqMap.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        ArrayList<Character> mostFrequentChars = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                mostFrequentChars.add(entry.getKey());
            }
        }

        if (freqMap.isEmpty()) {
            System.out.println("No valid characters found");
        } else {
            System.out.println("Most frequent character: " + mostFrequentChars);
            System.out.println("Frequency: " + maxCount);
        }

        sc.close();
    }
}
