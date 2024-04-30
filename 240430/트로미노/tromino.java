import java.io.*;
import java.util.stream.Stream;
import java.lang.Math;

public class Main {

    static int n, m;
    static int[][] matrix;

    static int answer = 0;

    public static void main(String[] args) throws Exception {

        initialization();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                typeOneCheck(i, j);
            }
        }
        
        System.out.println(answer);
        
        

    }

    static void typeOneCheck(int row, int col) { 

        int baseValue = matrix[row][col];

        if (inrangeCheck(row, col + 1) && inrangeCheck(row + 1, col)) {
            answer = Math.max(answer, baseValue + matrix[row][col + 1] + matrix[row + 1][col]);
        }

        if (inrangeCheck(row, col - 1) && inrangeCheck(row + 1, col)) {
            answer = Math.max(answer, baseValue + matrix[row][col - 1] + matrix[row + 1][col]);
        }

        if (inrangeCheck(row - 1, col) && inrangeCheck(row, col - 1)) {
            answer = Math.max(answer, baseValue + matrix[row - 1][col] + matrix[row][col - 1]);
        }

        if (inrangeCheck(row - 1, col) && inrangeCheck(row, col + 1)) {
            answer = Math.max(answer, baseValue + matrix[row - 1][col] + matrix[row][col + 1]);
        }

        if (inrangeCheck(row - 1, col) && inrangeCheck(row + 1, col)) {
            answer = Math.max(answer, baseValue + matrix[row - 1][col] + matrix[row + 1][col]);
        }

        if (inrangeCheck(row, col - 1) && inrangeCheck(row, col + 1)) { 
            answer = Math.max(answer, baseValue + matrix[row][col - 1] + matrix[row][col + 1]);
        }

        


    }

    static boolean inrangeCheck(int row, int col) {
        return (row >= 0 && row < n && col >= 0 && col < m);
    }

    static void initialization() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArray = br.readLine().split(" ");
        n = Integer.parseInt(inputArray[0]);
        m = Integer.parseInt(inputArray[1]);

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        
    }


}