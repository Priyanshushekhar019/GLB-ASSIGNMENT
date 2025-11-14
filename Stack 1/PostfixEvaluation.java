import java.util.*;

public class PostfixEvaluation {

    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();

        for (String token : expr.split(" ")) {

            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    case "%":
                        stack.push(a % b);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter postfix expression:");
        String expr = sc.nextLine(); 

        int result = evaluatePostfix(expr);

        System.out.println("Result = " + result);

        sc.close();
    }
}
