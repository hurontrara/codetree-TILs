import java.io.*;
import java.util.stream.Stream;
import java.util.*;


public class Main {

    static int size;
    static int[][] matrix;
    static int[][] dpMatrix;

    static int answer = 0;


    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine()); matrix = new int[size][size]; dpMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 0열, 0행
        dpMatrix[0][0] = matrix[0][0]; 

        for (int i = 1; i < size; i++) {

            dpMatrix[i][0] = dpMatrix[i - 1][0] + matrix[i][0];
            dpMatrix[0][i] = dpMatrix[0][i - 1] + matrix[0][i];

        }


        // logic
        for (int i = 0; i < size; i++) {
            answer = Math.max(answer, memo(size - 1, i));
        }

        // print
        System.out.print(answer);



    }

    static int memo(int row, int col) {

        if (dpMatrix[row][col] != 0) {
            return dpMatrix[row][col];
        }

        dpMatrix[row][col] = Math.max(memo(row - 1, col), memo(row, col - 1)) + matrix[row][col];

        return dpMatrix[row][col];

    }



}