import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int x;
    int y;

    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point point) {

        return this.x - point.x;

    }

}


public class Main {

    static int n;

    static List<Point> pointList = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] lMax;
    static int[] rMin;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        lMax = new int[n]; rMin = new int[n];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

            pointList.add(new Point(a, b));

        }

        Collections.sort(pointList);

        lMax[0] = pointList.get(0).y;
        rMin[n - 1] = pointList.get(n - 1).y;

        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], pointList.get(i).y);
        }

        for (int i = n - 2; i >= 0; i--) {
            rMin[i] = Math.min(rMin[i + 1], pointList.get(i).y);
        } 

        int cnt = 0;

        // 초기값은 직접
        Point init = pointList.get(0);
        if (init.y < rMin[1])
            cnt++;
        
        Point last = pointList.get(n - 1);
        if (last.y > lMax[n - 2])
            cnt++;


        for (int i = 1; i < n - 1; i++) {

            Point point = pointList.get(i);

            if (point.y < rMin[i + 1] && point.y > lMax[i - 1])
                cnt++;

        }
        
        
        System.out.print(cnt);




    }




}