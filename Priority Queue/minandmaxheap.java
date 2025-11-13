import java.util.*;

public class minandmaxheap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose type of heap:");
        System.out.println("1. Min-Heap");
        System.out.println("2. Max-Heap");
        System.out.print("Enter choice (1 or 2): ");
        int type = sc.nextInt();

        PriorityQueue<Integer> pq;
        if (type == 2) {
            pq = new PriorityQueue<>(Collections.reverseOrder());
            System.out.println("Max-Heap created!");
        } else {
            pq = new PriorityQueue<>(); 
            System.out.println("Min-Heap created!");
        }
        while (true) {
            System.out.println("Heap Operations");
            System.out.println("1. Insert element");
            System.out.println("2. Remove top element");
            System.out.println("3. Peek");
            System.out.println("4. Display heap elements");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int val = sc.nextInt();
                    pq.add(val);
                    System.out.println(val + " inserted into heap.");
                    break;

                case 2:
                    if (pq.isEmpty()) {
                        System.out.println("Heap is empty!");
                    } else {
                        System.out.println("Removed top element: " + pq.poll());
                    }
                    break;

                case 3:
                    if (pq.isEmpty()) {
                        System.out.println("Heap is empty!");
                    } else {
                        System.out.println("Top element (peek): " + pq.peek());
                    }
                    break;

                case 4:
                    if (pq.isEmpty()) {
                        System.out.println("Heap is empty!");
                    } else {
                        System.out.println("Heap elements: " + pq);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
