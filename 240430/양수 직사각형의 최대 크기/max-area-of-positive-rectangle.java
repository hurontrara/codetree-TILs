import java.io.*;
import java.util.stream.Stream;
import java.lang.Math;

public class Main {

    static int n, m;
    static int[][] matrix;

    static int answer = -1;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" ");
        n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 점 마킹
        for (int aRow = 0; aRow < n; aRow++) {
            for (int aCol = 0; aCol < m; aCol++) {
                for (int bRow = aRow; bRow < n; bRow++) {
                    for (int bCol = aCol; bCol < m; bCol++) {
                        rectangleCalculate(aRow, aCol, bRow, bCol);
                    }
                }
            }
        }

        System.out.print(answer);

    }

    static void rectangleCalculate(int aRow, int aCol, int bRow, int bCol) {

        for (int i = aRow; i <= bRow; i++) {
            for (int j = aCol; j <= bCol; j++) {
                if (matrix[i][j] < 1)
                    return;
            }
        }

        answer = Math.max(answer, (bRow - aRow + 1) * (bCol - aCol + 1));

    }


}