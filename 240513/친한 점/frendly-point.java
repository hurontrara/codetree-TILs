import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point point) {

        if (this.x == point.x)
            return this.y - point.y;
        
        return this.x - point.x;


    }


}

public class Main {

    static int n, m;
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Point> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());

            treeSet.add(new Point(x, y));

        }

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());

            Point nextPoint = treeSet.ceiling(new Point(x, y));

            if (nextPoint == null) {

                sb.append("-1 -1\n");

            } else {

                sb.append(nextPoint.x).append(" ").append(nextPoint.y).append("\n");

            }


        }

        System.out.print(sb);



    }


}


// x 좌표가 큰 점 + x 좌표가 갖고 y 좌표가 큰 점