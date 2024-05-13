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

        if (this.x == point.x) {
            return this.y - point.y;
        }
        
        return this.x - point.x;


    }


}


public class Main {

    static int n, m; // 서로 다른 n개의 점, m개의 질의

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

            int query = Integer.parseInt(br.readLine());

            Point point = treeSet.higher(new Point(query, Integer.MIN_VALUE));

            if (point != null) {
                treeSet.remove(point);
                sb.append(point.x).append(" ").append(point.y).append("\n");
            } else {
                sb.append("-1 -1 \n");
            }


        }

        System.out.print(sb);



    }




}