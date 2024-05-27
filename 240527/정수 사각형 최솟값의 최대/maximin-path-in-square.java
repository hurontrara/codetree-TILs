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

        dpMatrix[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dpMatrix[i][0] = Math.min(dpMatrix[i - 1][0], matrix[i][0]);
            dpMatrix[0][i] = Math.min(dpMatrix[0][i - 1], matrix[0][i]); 
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dpMatrix[i][j] = Math.min(Math.max(dpMatrix[i - 1][j], dpMatrix[i][j - 1]), matrix[i][j]);
            }
        }

        System.out.print(dpMatrix[n - 1][n - 1]);



    }


}