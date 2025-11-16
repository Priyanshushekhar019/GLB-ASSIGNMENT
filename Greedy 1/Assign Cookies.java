import java.util.*;

public class AssignCookies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of children: ");
        int n = sc.nextInt();
        int[] g = new int[n];

        System.out.println("Enter factors:");
        for (int i = 0; i < n; i++) {
            g[i] = sc.nextInt();
        }

        System.out.print("Enter number of cookies: ");
        int m = sc.nextInt();
        int[] s = new int[m];

        System.out.println("Enter cookie sizes:");
        for (int i = 0; i < m; i++) {
            s[i] = sc.nextInt();
        }

        int result = findContentChildren(g, s);
        System.out.println("Maximum number of content children = " + result);

        sc.close();
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s); 

        int i = 0;  
        int j = 0; 

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i;
    }
}
