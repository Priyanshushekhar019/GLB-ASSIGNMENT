import java.util.*;
public class hashmapimplementation {
    static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    static class MyHashMap {
        private final int SIZE = 1000;
        private Node[] buckets;

        public MyHashMap() {
            buckets = new Node[SIZE];
        }

        private int hash(int key) {
            return key % SIZE;
        }
        public void put(int key, int value) {
            int index = hash(key);
            if (buckets[index] == null) {
                buckets[index] = new Node(-1, -1);
            }
            Node prev = find(buckets[index], key);
            if (prev.next == null){
                prev.next = new Node(key, value);}
            else{
                prev.next.value = value; 
            }
        }
       
        public int get(int key) {
            int index = hash(key);
            if (buckets[index] == null) return -1;
            Node prev = find(buckets[index], key);
            if (prev.next == null) return -1;
            return prev.next.value;
        }
        public void remove(int key) {
            int index = hash(key);
            if (buckets[index] == null) return;
            Node prev = find(buckets[index], key);
            if (prev.next != null)
                prev.next = prev.next.next;
        }
        private Node find(Node head, int key) {
            Node prev = head, curr = head.next;
            while (curr != null && curr.key != key) {
                prev = curr;
                curr = curr.next;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyHashMap map = new MyHashMap();
        System.out.println("Choose operation:");
        System.out.println("1: put(key, value)");
        System.out.println("2: get(key)");
        System.out.println("3: remove(key)");
        System.out.println("4: exit");

        while (true) {
            System.out.print("\nEnter choice (1-4): ");
            int choice = sc.nextInt();

            if(choice == 1) {
                System.out.print("Enter key: ");
                int key = sc.nextInt();
                System.out.print("Enter value: ");
                int value = sc.nextInt();
                map.put(key, value);
                System.out.println("Key " + key + " inserted with value " + value);

            } else if (choice == 2) {
                System.out.print("Enter key to get value: ");
                int key = sc.nextInt();
                int val = map.get(key);
                if (val == -1)
                    System.out.println("Key not found");
                else
                    System.out.println("Value for key " + key + " = " + val);

            } else if (choice == 3) {
                System.out.print("Enter key to remove: ");
                int key = sc.nextInt();
                map.remove(key);
                System.out.println("Key " + key + " removed");

            } else if (choice == 4) {
                System.out.println("Exiting program");
                break;

            } else {
                System.out.println("Invalid choice, try again!");
            }
        }

        sc.close();
    }
}
