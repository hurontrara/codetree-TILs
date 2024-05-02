import java.io.*;
import java.util.stream.Stream;

public class Main {

    static int size;
    static int[][] matrix;
    static int[][] tmpMatrix;
    static int answer = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size];
        tmpMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        // 로직
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                setTmpMatrix();
                bomb(row, col);
                gravity();
                count();

            }
        }

        // 출력
        System.out.print(answer);

    }

    static void count() {

        int localAnswer = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (tmpMatrix[i][j] == 0)
                    continue;

                if (existCheck(i + 1, j) && tmpMatrix[i][j] == tmpMatrix[i + 1][j])
                    localAnswer++;

                if (existCheck(i, j + 1) && tmpMatrix[i][j] == tmpMatrix[i][j + 1])
                    localAnswer++;

            }
        }
        answer = Math.max(answer, localAnswer);

    }

    static void gravity() {

        int[] tmpArray = new int[size];
        int idx;

        for (int col = 0; col < size; col++) {

            idx = size - 1;
            for (int row = size - 1; row >= 0; row--) {
                
                if (tmpMatrix[row][col] != 0) {
                    tmpArray[idx--] = tmpMatrix[row][col];
                }

            }

            for (int row = 0; row < size; row++) {

                tmpMatrix[row][col] = tmpArray[row];
                tmpArray[row] = 0;

            }

        }


    }

    static void bomb(int row, int col) {

        int range = tmpMatrix[row][col];

        for (int localRange = 0; localRange < range; localRange++) {

            for (int dir = 0; dir < 4; dir++) {

                if (existCheck(row + localRange * dx[dir], col + localRange * dy[dir])) {

                    tmpMatrix[row + localRange * dx[dir]][col + localRange * dy[dir]] = 0;

                }


            }
        }


    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    static void setTmpMatrix() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                tmpMatrix[row][col] = matrix[row][col];
            }
        }
    }


}