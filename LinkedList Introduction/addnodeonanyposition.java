import java.util.*;

public class addnodeonanyposition {
    static class MyLinkedList {
        private static class Node {
            int val;
            Node next;
            Node(int v) { val = v; }
        }

        private Node dummy;
        private int size;

        public MyLinkedList() {
            dummy = new Node(-1);
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            Node cur = dummy.next;
            for (int i = 0; i < index; i++) cur = cur.next;
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0) index = 0;
            if (index > size) return;
            Node prev = dummy;
            for (int i = 0; i < index; i++) prev = prev.next;
            Node node = new Node(val);
            node.next = prev.next;
            prev.next = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            Node prev = dummy;
            for (int i = 0; i < index; i++) prev = prev.next;
            prev.next = prev.next.next;
            size--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();
        while (sc.hasNext()) {
            String cmd = sc.next();
            try {
                switch (cmd) {
                    case "get": {
                        int idx = sc.nextInt();
                        System.out.println(list.get(idx));
                        break;
                    }
                    case "addAtHead": {
                        int v = sc.nextInt();
                        list.addAtHead(v);
                        break;
                    }
                    case "addAtTail": {
                        int v = sc.nextInt();
                        list.addAtTail(v);
                        break;
                    }
                    case "addAtIndex": {
                        int idx = sc.nextInt();
                        int v = sc.nextInt();
                        list.addAtIndex(idx, v);
                        break;
                    }
                    case "deleteAtIndex": {
                        int idx = sc.nextInt();
                        list.deleteAtIndex(idx);
                        break;
                    }
                    default:
                        System.err.println("Unknown command: " + cmd);
                        if (sc.hasNextLine()) sc.nextLine();
                        break;
                }
            } catch (Exception e) {
                System.err.println("Error parsing command: " + cmd + " (" + e.getMessage() + ")");
                if (sc.hasNextLine()) sc.nextLine();
            }
        }
        sc.close();
    }
}
