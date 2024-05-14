import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int x;
    int y;
    int distance;

    Point(int x, int y) {

        this.x = x;
        this.y = y;
        this.distance = x + y;

    }

    @Override
    public int compareTo(Point point) {

        if (this.distance == point.distance) {

            if (this.x == point.x)
                return this.y - point.y;

            return this.x - point.x;

        }

        return this.distance - point.distance;

    }


}




public class Main {

    static int n, m; // n개의 점, m번의 연산

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Point> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());

            pq.add(new Point(x, y));

        }

        // 연산
        for (int i = 0; i < m; i++) {

            Point point = pq.poll();

            point.x += 2; point.y += 2; point.distance += 4;

            pq.add(point);


        }

        // 출력
        Point point = pq.poll();
        System.out.print(point.x + " " + point.y);



    }





}