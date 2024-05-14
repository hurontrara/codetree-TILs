import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    int x;

    Point(int x) {
        this.x = x;
    }

    @Override
    public int compareTo(Point point) {

        if (Math.abs(this.x) == Math.abs(point.x)) {
            return this.x - point.x;
        }

        return Math.abs(this.x) - Math.abs(point.x);

    } 

}

public class Main {

    static int size;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Point> queue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {

            int order = Integer.parseInt(br.readLine());

            if (order == 0) {

                if (queue.isEmpty()) {

                    sb.append("0 \n");

                } else {

                    sb.append(queue.poll().x).append("\n");

                }

            } else {

                queue.add(new Point(order));

            }


        }

        System.out.print(sb);


    }




}