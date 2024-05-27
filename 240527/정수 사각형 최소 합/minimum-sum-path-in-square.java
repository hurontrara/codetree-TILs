import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] matrix;
    static int[][] dpMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n]; dpMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dpMatrix[0][n - 1] = matrix[0][n - 1];
        for (int i = 1; i < n; i++) {
            dpMatrix[i][n - 1] = dpMatrix[i - 1][n - 1] + matrix[i][n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            dpMatrix[0][i] = dpMatrix[0][i + 1] + matrix[0][i];
        }



        for (int row = 1; row < n; row++) {
            
            for (int col = n - 2; col >= 0; col--) {

                dpMatrix[row][col] = Math.min(dpMatrix[row - 1][col], dpMatrix[row][col + 1]) + matrix[row][col];

            }
        }

        System.out.print(dpMatrix[n - 1][0]);


        



    }


}