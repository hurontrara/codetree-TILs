import java.io.*;
import java.util.stream.Stream;
import java.lang.Math;

public class Main {

    static int n, m;
    static int[][] matrix;

    static int answer = -1000000000;

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" ");
        n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 구조 세팅
        for (int aRow = 0; aRow < n; aRow++) {
            for (int aCol = 0; aCol < m; aCol++) { 
                for (int bRow = aRow; bRow < n; bRow++) {
                    for (int bCol = aCol; bCol < m; bCol++) {
                        for (int cRow = 0; cRow < n; cRow++) {
                            for (int cCol = 0; cCol < m; cCol++) {
                                for (int dRow = cRow; dRow < n; dRow++) {
                                    for (int dCol = cCol; dCol < m; dCol++) {
                                        calculate(aRow, aCol, bRow, bCol, cRow, cCol, dRow, dCol);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 답 출력
        System.out.print(answer);


    }

    static void calculate(int aRow, int aCol, int bRow, int bCol, int cRow, int cCol, int dRow, int dCol) {

        if (cRow >= aRow && cRow <= bRow && cCol >= aCol && cCol <= bCol)
            return;
        
        int localSum = 0;
        for (int i = aRow; i <= bRow; i++) {
            for (int j = aCol; j <= bCol; j++) {
                localSum += matrix[i][j];
            }
        }

        for (int i = cRow; i <= dRow; i++) {
            for (int j = cCol; j <= dCol; j++) {
                localSum += matrix[i][j];
            }
        }

        answer = Math.max(localSum, answer);

    }


}