import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int x;
    int next;
    int sum;

    Point(int x, int next) {

        this.x = x;
        this.next = next;
        this.sum = x + next;

    }

    @Override
    public int compareTo(Point point) {
        return this.sum - point.sum;

    }

}

public class Main {

    static int n, m, k;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static TreeSet<Integer> treeSet = new TreeSet<>();

    static PriorityQueue<Point> queue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());

        // 첫번째 배열에 대해서는 treeSet에 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        // 두번째 배열은 객체를 만들어 저장
        st = new StringTokenizer(br.readLine());
        int base = treeSet.first();
        for (int i = 0; i < m; i++) {

            queue.add(new Point(Integer.parseInt(st.nextToken()), base));

        }

        // k - 1번 반복
        for (int t = 0; t < k - 1; t++) {

            Point point = queue.poll();

            Integer next = treeSet.higher(point.next);

            if (next == null)
                continue;
            
            queue.add(new Point(point.x, next));


        }

        // k번째 
        Point finalPoint = queue.poll();
        System.out.print(finalPoint.x + finalPoint.next);


    }


}