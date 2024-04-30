import java.io.*;
import java.util.stream.Stream;

public class Main {

    static int size;
    static int happyNum;
    static int[][] matrix;

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        
        initialization();

        for (int i = 0; i < size; i++) {

            rowHappyCheck(i);
            colHappyCheck(i);

        }

        System.out.println(answer);

    }

    static void colHappyCheck(int col) {

        int leftNum = -1;
        int count = 1;

        for (int row = 0; row < size; row++) {
            int recentValue = matrix[row][col];

            if (matrix[row][col] == leftNum) {
                count++;
            } else {
                leftNum = matrix[row][col];
                count = 1;
            }

            if (count == happyNum) {
                answer++;
                return;
            }

        }

    }

    static void rowHappyCheck(int row) {
        
        int leftNum = -1;
        int count = 1;

        for (int col = 0; col < size; col++) {
            int recentValue = matrix[row][col];

            if (matrix[row][col] == leftNum) {
                count++;
            } else {
                leftNum = matrix[row][col];
                count = 1;
            }

            if (count == happyNum) {
                answer++;
                return;
            }

        }

    }

    static void initialization() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArray = br.readLine().split(" ");

        size = Integer.parseInt(inputArray[0]);
        happyNum = Integer.parseInt(inputArray[1]);

        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

    }

}