import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int num;
    int seq;

    Point(int num, int seq) {
        this.num = num;
        this.seq = seq;
    }

    @Override
    public int compareTo(Point point) {
        if (this.num == point.num)
            return this.seq - point.seq;
        return this.num - point.num;
    }

}


public class Main {

    static int n, q; // n개의 숫자, q개의 질의

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Integer> treeSet = new TreeSet<>();
    static TreeSet<Point> pointTreeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            treeSet.add(Integer.parseInt(st.nextToken()));

        }

        int cnt = 0;
        for (int value : treeSet) {

            pointTreeSet.add(new Point(value, cnt));
            cnt++;

        }

        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

            Point pointA = pointTreeSet.higher(new Point(a, -1));
            Point pointB = pointTreeSet.lower(new Point(b, 100001));

            if (pointA == null || pointB == null) {
                sb.append("0 \n");
                continue;
            }

            sb.append(pointB.seq - pointA.seq + 1).append("\n");

        }
        System.out.print(sb);


    }


}