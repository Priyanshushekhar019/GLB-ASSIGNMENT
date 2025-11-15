import java.util.*;

public class CircularQueue{

    static class MyCircularQueue {

        private int[] arr;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public MyCircularQueue(int k) {
            capacity = k;
            arr = new int[k];
            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            rear = (rear + 1) % capacity;
            arr[rear] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return arr[front];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            return arr[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void printQueue() {
            if (isEmpty()) {
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

        System.out.print("Enter capacity of circular queue: ");
        int k = sc.nextInt();

        MyCircularQueue q = new MyCircularQueue(k);

        while (true) {
            System.out.println("Choose Operation:");
            System.out.println("1. enQueue()");
            System.out.println("2. deQueue()");
            System.out.println("3. Front()");
            System.out.println("4. Rear()");
            System.out.println("5. isEmpty()");
            System.out.println("6. isFull()");
            System.out.println("7. Print Queue");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to insert: ");
                    int val = sc.nextInt();
                    System.out.println(q.enQueue(val) ? "Inserted" : "Queue Full");
                    break;

                case 2:
                    System.out.println(q.deQueue() ? "Deleted" : "Queue Empty");
                    break;

                case 3:
                    System.out.println("Front: " + q.Front());
                    break;

                case 4:
                    System.out.println("Rear: " + q.Rear());
                    break;

                case 5:
                    System.out.println("isEmpty: " + q.isEmpty());
                    break;

                case 6:
                    System.out.println("isFull: " + q.isFull());
                    break;

                case 7:
                    q.printQueue();
                    break;

                case 8:
                    System.out.println("Exiting");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
