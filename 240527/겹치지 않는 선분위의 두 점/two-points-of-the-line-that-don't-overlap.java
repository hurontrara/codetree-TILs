import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    long num;
    int coef;

    Point(long num, int coef) {
        this.num = num;
        this.coef = coef;
    }

    public Point() {
    }

    @Override
    public int compareTo(Point point) {

        if (this.num == point.num) {
            return (this.coef - point.coef);
        }

        return (this.num - point.num) < 0 ? -1 : 1;
    }



}

public class Main {

    static int n, m; // n개의 점, m개의 선분

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long answer = 0;

    static TreeSet<Point> treeSet = new TreeSet<>();

    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            treeSet.add(new Point(Long.parseLong(st.nextToken()), 1));
            treeSet.add(new Point(Long.parseLong(st.nextToken()), -1));

        }

        // 가지치기
        if (n == 2) {
            System.out.print(treeSet.last().num - treeSet.first().num);
            System.exit(0);
        }

        // 적어도 두 개는 박아야 함을 보장
        // 되는 것들 중에 최댓값

        long left = 1; long right = (long) 1e18;

        while (left <= right) {

            long mid = (left + right) / 2;

            // 다음 지점이 null이 아닐때 까지
            Point localPoint = new Point(treeSet.first().num, -2);
            int cnt = 1;
            while (true) {

                if (mid == 2) {
                    int i = 1;
                }

                Point futurePoint = new Point(localPoint.num + mid, -2);

                if (treeSet.higher(futurePoint) == null)
                    break;

                // 선분 안에 있는 것
                if (treeSet.higher(futurePoint).coef == -1 || treeSet.higher(futurePoint).num == futurePoint.num) {
                    localPoint = futurePoint;
                } // 선분 밖에 있음 ->
                else {
                    localPoint = new Point(treeSet.higher(futurePoint).num, -2);
                }


                cnt++;

            }

            if (cnt >= n) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                right = mid - 1;
            }


        }

        System.out.print(answer);


    }

}