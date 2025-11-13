import java.util.*;

public class bullsandcows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the secret number: ");
        String secret = sc.nextLine();

        System.out.print("Enter the guess number: ");
        String guess = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++; 
            } else {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s != g) {
                if (map.containsKey(g) && map.get(g) > 0) {
                    cows++;
                    map.put(g, map.get(g) - 1);
                }
            }
        }

        System.out.println(bulls + "A" + cows + "B");

        sc.close();
    }
}
