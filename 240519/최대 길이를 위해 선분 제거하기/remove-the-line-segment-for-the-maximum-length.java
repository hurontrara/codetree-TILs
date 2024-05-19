import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int value;
    int coef;

    Point(int value, int coef) {
        this.value = value;
        this.coef = coef;
    }

    @Override
    public int compareTo(Point point) {
        return this.value - point.value;
    }

}

class Segment implements Comparable<Segment> {

    int x1;
    int x2;
    int count = 0;

    Segment(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Segment segment) {

        if (this.x1 == segment.x1)
            return this.x2 - segment.x2;

        return this.x1 - segment.x1;
    }

}



public class Main {

    static int n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Point> pointList = new ArrayList<>();
    static TreeSet<Segment> segmentSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            pointList.add(new Point(x1, 1)); pointList.add(new Point(x2, -1));
            segmentSet.add(new Segment(x1, x2));
            
        }

        Collections.sort(pointList);

        int cnt = 0;
        int length = 0;
        Point totem = pointList.get(0);
        for (int i = 0; i < pointList.size(); i++) {

            Point point = pointList.get(i);
            cnt += point.coef;

            // 다음 사건까지 값을 더함
            if (cnt == 1) {

                Point nextPoint = pointList.get(i + 1);
                Segment segment = segmentSet.lower(new Segment(point.value, 1000000001));

                segment.count += nextPoint.value - point.value;

            }

            if (cnt == 0) {

                length += point.value - totem.value;
                totem = point;

            }


        }

        int value = Integer.MAX_VALUE;
        for (Segment segment : segmentSet) {
            value = Math.min(value , segment.count);
        }
        System.out.print(length - value);


    }



}