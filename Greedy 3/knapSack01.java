import java.util.*;

public class knapSack01 {

    static class Item {
        int value, weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter value and weight for each item:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        int result = greedyKnapsack(items, capacity);
        System.out.println("Maximum value= " + result);

        sc.close();
    }

    public static int greedyKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        int totalValue = 0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalValue += item.value;
            }
        }

        return totalValue;
    }
}
