import java.io.*;
import java.util.stream.Stream;


public class Main {

    static int size;
    static int[][] matrix;
    static int row, col;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        String[] rcArray = br.readLine().split(" ");
        row = Integer.parseInt(rcArray[0]) - 1; col = Integer.parseInt(rcArray[1]) - 1;

        // 로직
        bomb();
        gravity();

        // 출력
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void gravity() {

        int[] tempArray = new int[size];
        int localIndex = size - 1;

        for (int col = 0; col < size; col++) {

            for (int row = size - 1; row >= 0; row--) {

                if (matrix[row][col] > 0) {
                    tempArray[localIndex--] = matrix[row][col];
                }

            }

            for (int row = 0; row < size; row++) {
                matrix[row][col] = tempArray[row];
                tempArray[row] = 0;
            }

            localIndex = size - 1;


        }


    }

    static void bomb() {

        int bombRange = matrix[row][col];
        int currentRow = -1;
        int currentCol = -1;


        for (int range = 0; range < bombRange; range++) {

            for (int dir = 0; dir < 4; dir++) {
                currentRow = row + range * dx[dir];
                currentCol = col + range * dy[dir];
                if (existCheck(currentRow, currentCol))
                    matrix[currentRow][currentCol] = 0;
            }

        }
    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }


}