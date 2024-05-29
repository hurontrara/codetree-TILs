import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] aArray;
    static int[] bArray;

    static int[][] dpMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        aArray = new int[n * 2]; bArray = new int[n * 2];

        for (int i = 0; i < 2 * n; i++) {

            st = new StringTokenizer(br.readLine());
            aArray[i] = Integer.parseInt(st.nextToken()); bArray[i] = Integer.parseInt(st.nextToken());

        }

        // j = B Array
        dpMatrix = new int[2 * n][2 * n];
        dpMatrix[0][0] = aArray[0]; dpMatrix[0][1] = bArray[0];

        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j <= n; j++) {

                if (dpMatrix[i][j] != 0) {
                    dpMatrix[i + 1][j] = Math.max(dpMatrix[i + 1][j], dpMatrix[i][j] + aArray[i + 1]);
                    dpMatrix[i + 1][j + 1] = Math.max(dpMatrix[i + 1][j + 1], dpMatrix[i][j] + bArray[i + 1]);
                }

            }
        }

        System.out.print(dpMatrix[2 * n - 1][n]);
        


    }



}