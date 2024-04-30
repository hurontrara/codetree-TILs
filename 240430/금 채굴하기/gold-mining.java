import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.lang.Math;

class Gold {
    int x;
    int y;

    Gold(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int size;
    static int price;
    static int[][] matrix;
    static List<Gold> goldList = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        
        initialization();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                calculate(i, j);
            }
        }

        System.out.println(answer);


    }

    static void calculate(int row, int col) {

        int cost = -1;
        int count = 0;

        // 거리 넣기
        for (Gold goldObject : goldList) {
            pq.add(Math.abs(row - goldObject.x) + Math.abs(col - goldObject.y));
        }

        while (!pq.isEmpty()) {
            int localDistance = pq.poll();
            count++;
            cost = (localDistance * localDistance) + ((localDistance + 1) * (localDistance + 1));

            if (count * price >= cost)
                answer = Math.max(answer, count);
        }

    }

    static void initialization() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArray = br.readLine().split(" ");

        size = Integer.parseInt(inputArray[0]);
        price = Integer.parseInt(inputArray[1]);

        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1)
                    goldList.add(new Gold(i, j));
            }
        }

    }

}