import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static class Value implements Comparable<Value> {

        int reward;
        int cnt;

        Value(int reward, int cnt) {
            this.reward = reward;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Value value) {

            if (this.reward == value.reward)
                return this.cnt - value.cnt;

            return value.reward - this.reward;

        }
    }

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

            return point.time - this.time;

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

        int time = queue.peek().time;
        int sumReward = 0;

        PriorityQueue<Value> valueTreeSet = new PriorityQueue<>();

        int cnt = 0;
        while (time != -1) {

            while (!queue.isEmpty() && queue.peek().time == time) {
                Point poll = queue.poll();
                valueTreeSet.add(new Value(poll.reward, cnt));
                cnt++;
            }

            Value poll = valueTreeSet.poll();

            time--;

            if (poll == null)
                continue;
            else
                sumReward += poll.reward;


        }

        System.out.println(sumReward);

    }

}