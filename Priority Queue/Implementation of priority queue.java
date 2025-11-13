import java.util.*;

public class implementationofpriorityqueue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (true) {
            System.out.println("Priority Queue Operations");
            System.out.println("1. Insert element");
            System.out.println("2. Remove element");
            System.out.println("3. Peek");
            System.out.println("4. Display queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int val = sc.nextInt();
                    pq.add(val);
                    System.out.println(val + " inserted.");
                    break;

                case 2:
                    if (pq.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Removed element: " + pq.poll());
                    }
                    break;

                case 3:
                    if (pq.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Smallest element: " + pq.peek());
                    }
                    break;

                case 4:
                    if (pq.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Current queue elements: " + pq);
                    }
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
