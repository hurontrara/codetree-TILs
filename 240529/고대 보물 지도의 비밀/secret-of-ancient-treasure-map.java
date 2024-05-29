import java.io.*;
import java.util.*;


public class Main {

    static int n, k;
    static int[] array;
    static int[][] dpMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int MIN_VALUE = -1000000000;

    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        array = new int[n];
        dpMatrix = new int[n][k + 2]; // 마지막 열은 수납용

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // init
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < k + 1; j++) {
                dpMatrix[i][j] = MIN_VALUE;
            }

            if (array[i] >= 0) {
                dpMatrix[i][0] = array[i];
            } else {
                dpMatrix[i][1] = array[i];
            }


        }

        // logic
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= k; j++) {

                if (dpMatrix[i][j] != MIN_VALUE && existCheck(i + 1, j + 1) && array[i + 1] < 0) {

                    dpMatrix[i + 1][j + 1] = Math.max(dpMatrix[i + 1][j + 1], dpMatrix[i][j] + array[i + 1]);

                }

                else if (dpMatrix[i][j] != MIN_VALUE && existCheck(i + 1, j) && array[i + 1] > 0) {

                    dpMatrix[i + 1][j] = Math.max(dpMatrix[i + 1][j], dpMatrix[i][j] + array[i + 1]);

                }

            }
        }

        // print
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k + 1; j++) {
                answer = Math.max(answer, dpMatrix[i][j]);
            }
        }
        System.out.print(answer);


    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col <= k + 1;
    }



}