import java.io.*;
import java.util.stream.Stream;

public class Main {

    static int size, time;
    static int[][] matrix;
    static int targetColumn;
    static int targetRow = -1;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stArray = br.readLine().split(" ");
        size = Integer.parseInt(stArray[0]); time = Integer.parseInt(stArray[1]);
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 로직
        for (int i = 0; i < time; i++) {
            targetColumn = Integer.parseInt(br.readLine()) - 1;

            setTargetRow();
            if (targetRow == -1)
                continue;

            bomb();

            gravity();
        }

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
        int idx;

        for (int col = 0; col < size; col++) {

            idx = size - 1;

            for (int row = size - 1; row >= 0; row--) {

                if (matrix[row][col] != 0) {

                    tempArray[idx--] = matrix[row][col];

                }

            }

            for (int row = 0; row < size; row++) {
                matrix[row][col] = tempArray[row];
            }

            for (int i = 0; i < size; i++) {
                tempArray[i] = 0;
            }


        }


    }

    static void bomb() {

        int range = matrix[targetRow][targetColumn];

        for (int localRange = 0; localRange < range; localRange++) {

            for (int dir = 0; dir < 4; dir++) {

                if (existCheck(targetRow + localRange * dx[dir], targetColumn + localRange * dy[dir])) {
                    matrix[targetRow + localRange * dx[dir]][targetColumn + localRange * dy[dir]] = 0;
                }

            }

        }

    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }


    static void setTargetRow() {

        for (int row = 0; row < size; row++) {
            if (matrix[row][targetColumn] != 0) {
                targetRow = row;
                return;
            }
        }

        targetRow = -1;
    }


}