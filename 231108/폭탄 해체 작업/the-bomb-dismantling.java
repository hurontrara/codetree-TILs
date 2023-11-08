import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Point implements Comparable<Point> {

        int reward;
        int time; // 출발시간제한

        Point(int reward, int time) {
            this.reward = reward;
            this.time = time;
        }

        public int compareTo(Point point) {

            if (this.time == point.time)
                return point.reward - this.reward;

            return this.time - point.time;

        }

    }


    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static PriorityQueue<Point> queue = new PriorityQueue<>();

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            queue.add(new Point(sc.nextInt(), sc.nextInt() - 1));
        }

        greedy();

    }

    private static void greedy() {

        int time = 0;
        int globalReward = 0;

        while (!queue.isEmpty()) {

            Point poll = queue.poll();

            if (poll.time < time)
                continue;

            time = poll.time + 1;
            globalReward += poll.reward;

        }

        System.out.println(globalReward);

    }


}