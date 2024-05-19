import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int value;
    int coef;
    int end;

    Point(int value, int coef, int end) {

        this.value = value;
        this.coef = coef;
        this.end = end;

    }

    @Override
    public int compareTo(Point point) {
        
        if (this.value == point.value)
            return point.end - this.end;
        
        return this.value - point.value;

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

            pointList.add(new Point(a, 1, b)); pointList.add(new Point(b, -1, b));

        }

        Collections.sort(pointList);

        int cnt = 0;
        int answer = 0;
        for (Point point : pointList) {

            cnt += point.coef;

            answer = Math.max(cnt, answer);


        }
        System.out.print(answer);




    }


}