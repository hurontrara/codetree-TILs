import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static class Pair implements Comparable<Pair> {

        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Pair pair) {

            if (this.start == pair.start)
                return this.end - pair.end;

            return this.start - pair.start;

        }
    }


    static class Point implements Comparable<Point> {

        int start;
        int end;
        int distance;

        Point(int start, int end) {
            this.start = start;
            this.end = end;
            this.distance = end - start;
        }


        @Override
        public int compareTo(Point point) {

            if (this.start == point.start && this.end == point.end)
                return 0;

            if (this.distance == point.distance)
                return this.start - point.start;

            return this.distance - point.distance;

        }



    }

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static PriorityQueue<Point> queue = new PriorityQueue<>();


    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            queue.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        greedy();

    }

    private static void greedy() {

        TreeSet<Pair> pairSet = new TreeSet<>();


        int cnt = 0;
        while (!queue.isEmpty()) {

            Point poll = queue.poll();

            Pair leftPair = pairSet.floor(new Pair(poll.end, Integer.MAX_VALUE));
            Pair rightPair = pairSet.ceiling(new Pair(poll.start, Integer.MIN_VALUE));

            if (leftPair != null && leftPair.end > poll.start)
                continue;

            if (rightPair != null && rightPair.start < poll.end)
                continue;

            cnt++;
            pairSet.add(new Pair(poll.start, poll.end));


        }

        System.out.println(n - cnt);


    }


}