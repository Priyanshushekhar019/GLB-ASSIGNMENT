import java.util.*;

public class QueueUsingStack{

    static class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            shiftStacks();
            return stack2.isEmpty() ? -1 : stack2.pop();
        }

        public int peek() {
            shiftStacks();
            return stack2.isEmpty() ? -1 : stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        private void shiftStacks() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

        public void printQueue() {
            shiftStacks();
            System.out.print("Queue: ");
            for (int x : stack2) System.out.print(x + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue q = new MyQueue();

        while (true) {
            System.out.println("Choose Operation:");
            System.out.println("1. push()");
            System.out.println("2. pop()");
            System.out.println("3. peek()");
            System.out.println("4. empty()");
            System.out.println("5. Print Queue");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    q.push(val);
                    System.out.println("Inserted " + val);
                    break;

                case 2:
                    int removed = q.pop();
                    if (removed == -1)
                        System.out.println("Queue is empty!");
                    else
                        System.out.println("Popped: " + removed);
                    break;

                case 3:
                    int front = q.peek();
                    if (front == -1)
                        System.out.println("Queue is empty!");
                    else
                        System.out.println("Front: " + front);
                    break;

                case 4:
                    System.out.println("empty: " + q.empty());
                    break;

                case 5:
                    q.printQueue();
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
