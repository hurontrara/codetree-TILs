import java.io.*;
import java.util.*;


public class Main {

    static int size, k; // size * size 의 크기, m 길이의 정사각형
    static int[][] matrix;
    static int[][] sumMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        matrix = new int[size + 1][size + 1]; sumMatrix = new int[size + 1][size + 1];

        for (int i = 1; i < size + 1; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < size + 1; j++) {

                matrix[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        // 부분합
        for (int i = 1; i < size + 1; i++) {

            for (int j = 1; j < size + 1; j++) {

                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j];

            }

        }


        // 길이가 k인 사각형
        int answer = 0;
        for (int i = k; i < size + 1; i++) {
            for (int j = k; j < size + 1; j++) {

                int count = sumMatrix[i][j] - sumMatrix[i - k][j] - sumMatrix[i][j - k] + sumMatrix[i - k][j - k];
                answer = Math.max(answer, count);

            }
        }

        System.out.print(answer);





    }



}