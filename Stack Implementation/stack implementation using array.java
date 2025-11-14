import java.util.*;

public class stackimplementation {

    static class MyStack {
        private int[] arr;
        private int top;
        private int capacity;

        public MyStack(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            top = -1;
        }

        public void push(int val) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            arr[++top] = val;
            System.out.println("Pushed: " + val);
        }
        public int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top--];
        }
        public int peek() {
            if (top == -1) {
                System.out.println("Stack Empty");
                return -1;
            }
            return arr[top];
        }
        public boolean isEmpty() {
            return top == -1;
        }
        public void printStack() {
            if (top == -1) {
                System.out.println("Stack is empty");
                return;
            }
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack capacity: ");
        int n = sc.nextInt();

        MyStack stack = new MyStack(n);

        while (true) {
            System.out.println("Choose operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Is Empty?");
            System.out.println("5. Print Stack");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;

                case 2:
                    int popped = stack.pop();
                    if (popped != -1)
                        System.out.println("Popped: " + popped);
                    break;

                case 3:
                    int top = stack.peek();
                    if (top != -1)
                        System.out.println("Top element: " + top);
                    break;

                case 4:
                    System.out.println(stack.isEmpty() ? "Stack is empty" : "Stack is not empty");
                    break;

                case 5:
                    stack.printStack();
                    break;

                case 6:
                    System.out.println("Exiting");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
