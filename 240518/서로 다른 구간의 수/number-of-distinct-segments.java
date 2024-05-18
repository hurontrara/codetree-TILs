import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int num;
    int coef;

    Point(int num, int coef) {
        this.num = num;
        this.coef = coef;
    }

    @Override
    public int compareTo(Point point) {
        return this.num - point.num;

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

        int cnt = 0;
        int value = 0;
        for (Point point : pointList) {

            value += point.coef;

            if (value == 0)
                cnt++;

        }

        System.out.print(cnt);


    }


}