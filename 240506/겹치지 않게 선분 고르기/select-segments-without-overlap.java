import java.io.*;
import java.util.stream.Stream;
import java.util.*;

class Line implements Comparable<Line> {

    int x;
    int y;

    Line(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Line line) {
        return this.y - line.y;
    }

}

public class Main {

    static int count;
    static int row = -1;
    static PriorityQueue<Line> lineQueue = new PriorityQueue<>();
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int[] array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            lineQueue.add(new Line(array[0], array[1]));
        }

        // 로직
        counting();

        // 출력
        System.out.print(answer);




    }

    static void counting() {

        while (!lineQueue.isEmpty()) {

            Line line = lineQueue.poll();

            if (line.x > row) {
                row = line.y;
                answer++;
            }
 
        }

    }




}