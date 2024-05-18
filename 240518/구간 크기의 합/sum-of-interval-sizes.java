import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int x;
    int coef;

    Point(int x, int coef) {
        this.x = x;
        this.coef = coef;
    }

    @Override
    public int compareTo(Point point) {
        return this.x - point.x;
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
        int answer = 0;
        int left = pointList.get(0).x;

        for (int i = 0; i < pointList.size(); i++ ) {

            Point point = pointList.get(i);
        
            cnt += point.coef;

            if (cnt == 0) {
                answer += point.x - left;

                if (point != pointList.get(pointList.size() - 1))
                    left = pointList.get(i + 1).x;

            }

            


        }
        System.out.print(answer);


    }


}