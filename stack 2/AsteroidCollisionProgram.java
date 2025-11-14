import java.util.*;

public class AsteroidCollisionProgram {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {

                if (stack.peek() < -ast) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -ast) {
                    stack.pop();
                }

                destroyed = true; 
                break;
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of asteroids: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter asteroid values:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = asteroidCollision(arr);

        System.out.println("Asteroids after collisions:");
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }
}
