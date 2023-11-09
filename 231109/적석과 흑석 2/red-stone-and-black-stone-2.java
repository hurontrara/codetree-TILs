import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Pair implements Comparable<Pair> {

        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }


        @Override
        public int compareTo(Pair pair) {

            if (this.b == pair.b)
                return this.a - pair.a;

            return this.b - pair.b;

        }
    }


    static class Point implements Comparable<Point> {

        int a;
        int b;

        Point(int a, int b) {
            this.a = a;
            this.b = b;
        }


        @Override
        public int compareTo(Point point) {

            if (this.a == point.a)
                return this.b - point.b;

            return this.a - point.a;

        }

    }

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int m = sc.nextInt();

    static PriorityQueue<Integer> redQueue = new PriorityQueue<>();
    static PriorityQueue<Point> blackQueue = new PriorityQueue<>();

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            redQueue.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            blackQueue.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        greedy();



    }

    private static void greedy() {

        PriorityQueue<Pair> localQueue = new PriorityQueue<>();

        int cnt = 0;
        while (!redQueue.isEmpty()) {

            Integer redBall = redQueue.poll();

            while (!blackQueue.isEmpty() && blackQueue.peek().a <= redBall) {

                Point blackBall = blackQueue.poll();

                localQueue.add(new Pair(blackBall.a, blackBall.b));
            }

            while (!localQueue.isEmpty()) {

                Pair localBall = localQueue.poll();

                if (localBall.b < redBall)
                    continue;

                cnt++;
                break;

            }



        }

        System.out.println(cnt);


    }


}