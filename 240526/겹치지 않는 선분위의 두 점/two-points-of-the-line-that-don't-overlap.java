import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    long num;
    int coef;

    Point(long num, int coef) {
        this.num = num;
        this.coef = coef;
    }

    @Override
    public int compareTo(Point point) {

        if (this.num == point.num) {
            return this.coef - point.coef;
        }

        return (this.num - point.num) < 0 ? -1 : 1;
    }



}

public class Main {

    static int n, m; // n개의 점, m개의 선분
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int answer = 0;

    static TreeSet<Point> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            treeSet.add(new Point(Long.parseLong(st.nextToken()), 1));
            treeSet.add(new Point(Long.parseLong(st.nextToken()), -1));

        }

        // 가지치기
        if (m == 2) {
            System.out.print(treeSet.last().num - treeSet.first().num);
            System.exit(0);
        }

        // 두 개는 끝점이고 + 적어도 하나는 박아야 함을 보장
        // 되는 것들 중에 최댓값

        long left = 0; long right = (long) 1e18;

        while (left <= right) {

            long mid = (left + right) / 2;

            // 다음 지점이 null이 아닐때 까지
            Point localPoint = new Point(treeSet.first().num + mid, -2);
            int cnt = 2;
            while (treeSet.higher(localPoint) != null) {

                cnt++;
                localPoint = treeSet.higher(localPoint);

            }

            if (cnt >= 2) {
                left = mid + 1;
                answer = Math.max(answer, cnt);
            } else {
                right = mid - 1;
            }

        }

        System.out.print(answer);

        
    }

}