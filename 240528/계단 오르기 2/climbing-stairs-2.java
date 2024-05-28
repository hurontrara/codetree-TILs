import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] array;

    static int[][] dpMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        array = new int[n + 1];
        dpMatrix = new int[n + 1][4];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 초기화
        dpMatrix[1][1] = array[1];
        dpMatrix[2][0] = array[2];

        // logic
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                
                if (dpMatrix[i][j] > 0) {

                    int firstRow = i + 1; int firstCol = j + 1;
                    int secondRow = i + 2; int secondCol = j;

                    if (existCheck(firstRow, firstCol)) {
                        dpMatrix[firstRow][firstCol] = Math.max(dpMatrix[i][j] + array[firstRow], dpMatrix[firstRow][firstCol]);
                    }

                    if (existCheck(secondRow, secondCol)) {
                        dpMatrix[secondRow][secondCol] = Math.max(dpMatrix[i][j] + array[secondRow], dpMatrix[secondRow][secondCol]);
                    }

                }

            }
        }

        // print
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dpMatrix[n][i]);
        }
        System.out.print(answer);


    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row <= n && col >= 0 && col < 4;
    }
}