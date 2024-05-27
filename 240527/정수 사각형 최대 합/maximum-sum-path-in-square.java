import java.io.*;
import java.util.*;



public class Main {

    static int size;
    static int[][] matrix;
    static int[][] dpMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size];
        dpMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < size; j++) {

                matrix[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        dpMatrix[0][0] = matrix[0][0];
        for (int i = 1; i < size; i++) {

            dpMatrix[i][0] = dpMatrix[i - 1][0] + matrix[i][0];
            dpMatrix[0][i] = dpMatrix[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                dpMatrix[i][j] = Math.max(dpMatrix[i - 1][j], dpMatrix[i][j - 1]) + matrix[i][j];
            }
        }

        // 합 출력
        int answer = 0;
        for (int i = 0; i < size; i++) {
            answer = Math.max(answer, dpMatrix[size - 1][i]);
        }
        System.out.print(answer);




        


    }
}