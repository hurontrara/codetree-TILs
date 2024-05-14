import java.io.*;
import java.util.*;

public class Main {

    static int size;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {

            queue.add(-1 * Integer.parseInt(st.nextToken()));

        }

        // {-1, -5, -3, -2, -8}
        while (queue.size() > 1) {

            int firstValue = -1 * queue.poll(); // 8
            int secondValue = -1 * queue.poll(); // 5

            int distance = firstValue - secondValue; // 3

            if (distance == 0)
                continue;
            
            queue.add(-1 * distance);


        } 

        if (queue.isEmpty())
            System.out.print(-1);
        else
            System.out.print(-1 * queue.poll());



    }

}