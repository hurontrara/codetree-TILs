import java.io.*;
import java.util.*;


public class Main {

    static int n;

    static int[][] matrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        matrix = new int[1000 + 1][1000 + 1];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken()); int row = Integer.parseInt(st.nextToken());

            matrix[row][col] = 1;

        }

        for (int row = 2; row <= 1000; row += 2) {
            for (int col = 2; col <= 1000; col += 2){

                matrix[row][col] = matrix[row - 2][col] + matrix[row][col - 2] - matrix[row - 2][col -2] + matrix[row - 1][col - 1];

            }
        }

        int answer = 1000;
        for (int row = 2; row <= 1000; row += 2){
            for (int col = 2; col <= 1000; col += 2){

                int a = matrix[row][col];
                int b = matrix[1000][col] - a;
                int c = matrix[row][1000] - a;
                int d = matrix[1000][1000] - b - c - a;

                answer = Math.min(Math.max(Math.max(Math.max(a, b), c), d), answer);

            }
        }
        System.out.print(answer);


    }


}