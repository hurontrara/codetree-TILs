import java.io.*;
import java.util.*;

public class Main {

    static int size;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    static int[] array;

    static int summation = 0;

    static float mean = 0;

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());

        array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 초기화
        queue.add(array[size - 1]);
        summation += array[size - 1];

        for (int i = size - 2; i >= 1; i--) {

            summation += array[i];
            queue.add(array[i]);

            int peek = queue.peek();
            mean = Math.max(mean, (summation - peek) / (float) (queue.size() - 1) );


        }

        System.out.printf("%.2f", mean);



    }


}