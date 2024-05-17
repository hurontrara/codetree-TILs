import java.io.*;
import java.util.*;

public class Main {

    static int size;

    static int[][] matrix;
    static int[][] sumMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());
        matrix = new int[size + 1][size + 1]; sumMatrix = new int[size + 1][size + 1];

        for (int i = 1; i < size + 1; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < size + 1; j++) {

                matrix[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j];
            }
        }

        int value = 0;
        int row = 0;
        int col = 0;
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {

                value = Integer.MAX_VALUE;
                for (int localRow = 0; localRow < i; localRow++) {
                    if (sumMatrix[localRow][j] < value) {
                        row = localRow;
                        value = sumMatrix[localRow][j];
                    }
                }

                value = Integer.MAX_VALUE;
                for (int localCol = 0; localCol < j; localCol++) {
                    if (sumMatrix[i][localCol] - sumMatrix[i - 1][localCol] < value) {
                        col = localCol;
                        value = sumMatrix[i][localCol] - sumMatrix[i - 1][localCol];
                    }
                }

                // find answer
                answer = Math.max(answer, sumMatrix[i][j] - sumMatrix[row][j] - sumMatrix[i][col] + sumMatrix[row][col]);

            }
        }

        System.out.print(answer);





    }



}