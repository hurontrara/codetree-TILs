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


public class Main {

    static int n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<Point> pointList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            pointList.add(new Point(a, 1)); pointList.add(new Point(b, -1));


        }

        Collections.sort(pointList);

        int cnt = 0;
        int answer = 0;
        Point left = pointList.get(0);
        for (int i = 0; i < pointList.size(); i++) {

            Point point = pointList.get(i);

            cnt += point.coef;

            if (cnt == 0) {

                answer = Math.max(answer, point.value - left.value);

                if (i != pointList.size() - 1) {
                    left = pointList.get(i + 1);
                }

            }


        }
        System.out.print(answer);



    }



}