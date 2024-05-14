import java.io.*;
import java.util.*;

public class Main {

    static int size;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {

            queue.add(Integer.parseInt(st.nextToken()));

            if (queue.size() < 3) {
                sb.append("-1 \n");
                continue;
            }

            int first = queue.poll(); int second = queue.poll(); int third = queue.poll();

            sb.append(first * second * third).append("\n");

            queue.add(first); queue.add(second); queue.add(third);

        }

        System.out.print(sb);

    }

}