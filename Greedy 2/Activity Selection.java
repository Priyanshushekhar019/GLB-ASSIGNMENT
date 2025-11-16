import java.util.*;

public class ActivitySelection {

    static class Activity {
        int start, end;

        Activity(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of activities: ");
        int n = sc.nextInt();

        Activity[] activities = new Activity[n];

        System.out.println("Enter start and end time for each activity:");
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            activities[i] = new Activity(s, e);
        }

        int maxActivities = selectActivities(activities);
        System.out.println("Maximum number of activities = " + maxActivities);

        sc.close();
    }

    public static int selectActivities(Activity[] activities) {
        Arrays.sort(activities, (a, b) -> a.end - b.end);

        int count = 1; 
        int lastEndTime = activities[0].end;

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastEndTime) {
                count++;
                lastEndTime = activities[i].end;
            }
        }

        return count;
    }
}
