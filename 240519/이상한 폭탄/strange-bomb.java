import java.io.*;
import java.util.*;

class Index implements Comparable<Index> {

    int index;
    int num;

    Index(int index, int num) {
        this.index = index;
        this.num = num;
    }

    @Override
    public int compareTo(Index index) {

        return this.index - index.index;

    }

}

class Point implements Comparable<Point> {

    int num;
    int index;
    boolean boomed = false;


    Point(int num, int index) {
        this.num = num;
        this.index = index;
    }

    @Override
    public int compareTo(Point point) {

        if (this.num == point.num) {
            return this.index - point.index;
        }

        return this.num - point.num;
    }


}


public class Main {

    static int n, k; // n개의 수, k개 안짝

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static TreeSet<Point> treeSet = new TreeSet<>();
    static Queue<Index> indexQueue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());

        int max = -1;
        for (int i = 0; i < n; i++) {

            // insert
            int input = Integer.parseInt(br.readLine());
            Point midPoint = new Point(input, i);
            treeSet.add(midPoint);
            indexQueue.add(new Index(i, input));

            // check
            Point leftPoint = treeSet.lower(midPoint);

            if (leftPoint != null && leftPoint.num == input) {

                max = Math.max(max, input);

            }

            // delete
            if (i >= k) {

                Index index = indexQueue.poll();

                treeSet.remove(treeSet.higher(new Point(index.num, -1)));

            }


        }

        System.out.print(max);



    }



}