import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int a;
    int coef;

    Point(int a, int coef) {
        this.a = a;
        this.coef = coef;
    }

    @Override
    public int compareTo(Point point) {

        return this.a - point.a;

    }

}


public class Main {

    static int n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Point> pointList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

            pointList.add(new Point(a, 1)); pointList.add(new Point(b, -1));

        }

        Collections.sort(pointList);

        int value = 0;
        int answer = 0;
        for (Point point : pointList) {

            value += point.coef;

            answer = Math.max(answer, value);

        }

        System.out.print(answer);


    }


}