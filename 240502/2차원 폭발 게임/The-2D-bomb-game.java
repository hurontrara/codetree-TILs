import java.io.*;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static int size, bombCount, time;
    static int[][] matrix;
    static Queue<Integer> queue = new LinkedList<>();
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sbtArray = br.readLine().split(" ");
        size = Integer.parseInt(sbtArray[0]); bombCount = Integer.parseInt(sbtArray[1]); time = Integer.parseInt(sbtArray[2]);
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 로직
        for (int i = 0; i < time; i++) {

            while (bombProcess()) {};
            rotate();
            gravity();
        }
        while (bombProcess()) {};

        // 출력
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != 0)
                    answer++;
            }
        }
        System.out.print(answer);


    }

    static void gravity() {

        int[] tempArray = new int[size];
        int idx;

        for (int col = 0; col < size; col++) {

            idx = size - 1;
            for (int row = size - 1; row >= 0; row--) {

                if (matrix[row][col] != 0) {
                    tempArray[idx--] = matrix[row][col];
                }


            }

            for (int i = 0; i < size; i++) {
                matrix[i][col] = tempArray[i];
                tempArray[i] = 0;
            }

        }
    }


    static void rotate() {

        for (int col = 0; col < size; col++) {
            for (int row = size - 1; row >= 0; row--) {
                queue.add(matrix[row][col]);
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = queue.poll();
            }
        }


    }


    static boolean bombProcess() {

        boolean isBomb = false;

        for (int col = 0; col < size; col++) {

            for (int row = 0; row < size; row++) {

                int diff = getDiff(row, col);
                if (matrix[row][col] != 0 && diff >= bombCount) {


                    isBomb = true;
                    for (int k = 0; k < diff; k++) {
                        matrix[row + k][col] = 0;
                    }

                }

            }

        }

        gravity();

        return isBomb;


    }

    static int getDiff(int row, int col) {

        int value = matrix[row][col];
        int count = 0;

        for (int i = row; i <= size - 1; i++) {

            if (matrix[i][col] == value){
                count++;
            }
            else {
                return count;
            }

        }

        return count;

    }


}