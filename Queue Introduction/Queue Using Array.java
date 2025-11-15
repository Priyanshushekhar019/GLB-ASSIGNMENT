import java.util.*;

public class QueueUsingArray {

    static class MyQueue {
        int[] arr;
        int front, rear, size, capacity;

        public MyQueue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }
        public void enqueue(int val) {
            if (size == capacity) {
                System.out.println("Queue Overflow");
                return;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = val;
            size++;
            System.out.println("Enqueued: " + val);
        }

        public int dequeue() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int removed = arr[front];
            front = (front + 1) % capacity;
            size--;
            return removed;
        }
        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        public void printQueue() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue capacity: ");
        int cap = sc.nextInt();

        MyQueue q = new MyQueue(cap);

        while (true) {
            System.out.println("Choose Operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Print Queue");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = sc.nextInt();
                    q.enqueue(val);
                    break;

                case 2:
                    int removed = q.dequeue();
                    if (removed != -1)
                        System.out.println("Dequeued: " + removed);
                    break;

                case 3:
                    int front = q.peek();
                    if (front != -1)
                        System.out.println("Front Element: " + front);
                    break;

                case 4:
                    q.printQueue();
                    break;

                case 5:
                    System.out.println("Exiting");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
