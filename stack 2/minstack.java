import java.util.*;

public class minstack{

    static class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
            System.out.println("Pushed: " + val);
        }
        public int pop() {
            if (stack.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }

            int removed = stack.pop();

            if (removed == minStack.peek()) {
                minStack.pop();
            }

            return removed;
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return minStack.peek();
        }

        public int top() {
            if (stack.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return stack.peek();
        }

        public void printStack() {
            System.out.println("Stack: " + stack);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinStack ms = new MinStack();

        while (true) {
            System.out.println("Choose operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Get Min");
            System.out.println("5. Print Stack");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int v = sc.nextInt();
                    ms.push(v);
                    break;

                case 2:
                    int popped = ms.pop();
                    if (popped != -1)
                        System.out.println("Popped: " + popped);
                    break;

                case 3:
                    int top = ms.top();
                    if (top != -1)
                        System.out.println("Top element: " + top);
                    break;

                case 4:
                    int min = ms.getMin();
                    if (min != -1)
                        System.out.println("Minimum element: " + min);
                    break;

                case 5:
                    ms.printStack();
                    break;

                case 6:
                    System.out.println("Exiting");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
