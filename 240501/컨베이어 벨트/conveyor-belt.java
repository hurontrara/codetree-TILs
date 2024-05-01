import java.io.*;
import java.util.stream.Stream;


public class Main {

    static int size, time;
    static int[][] matrix;


    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stArray = br.readLine().split(" ");
        size = Integer.parseInt(stArray[0]); time = Integer.parseInt(stArray[1]);

        matrix = new int[2][size];

        for (int i = 0; i < 2; i++) { 
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 로직
        for (int i = 0; i < time; i++) {
            rotate();
        }

        // 출력
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void rotate() {

        int upTemp = matrix[0][size - 1];
        int downTemp = matrix[1][size - 1];

        for (int i = size - 1; i > 0; i--) {
            matrix[0][i] = matrix[0][i - 1];
            matrix[1][i] = matrix[1][i - 1];
        }

        matrix[0][0] = downTemp;
        matrix[1][0] = upTemp;

    }


}