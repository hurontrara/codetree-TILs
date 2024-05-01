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
        matrix = new int[3][size];
        for (int i = 0; i < 3; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 세팅
        for (int i = 0; i < time; i++) {
            rotate();
        }

        // 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    static void rotate() {
        int upTemp = matrix[0][size - 1];
        int midTemp = matrix[1][size - 1];
        int bottomTemp = matrix[2][size - 1];

        for (int i = 0; i < 3; i++) { 
            for (int j = size - 1; j > 0; j--) {
                matrix[i][j] = matrix[i][j - 1];
            }
        }

        matrix[0][0] = bottomTemp;
        matrix[1][0] = upTemp;
        matrix[2][0] = midTemp;

    }


}