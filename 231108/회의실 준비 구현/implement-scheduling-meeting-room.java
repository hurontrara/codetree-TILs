import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Point implements Comparable<Point> {

        int start;
        int end;

        Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Point point) {

            if (this.end == point.end)
                return this.start - point.start;
            else
                return this.end - point.end;

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

        int time = 0;
        int cnt = 0;

        while (!queue.isEmpty()) {
            Point pollValue = queue.poll();

            if (time > pollValue.start)
                continue;

            time = pollValue.end;
            cnt++;

        }

        System.out.println(cnt);



    }


}