import java.io.*;
import java.util.*;

public class Main {

    static int n, m; // n개의 숫자, 합이 M이 되도록 하는 경우의 수
    static int[] array;

    static long[][] dpMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        array = new int[n]; dpMatrix = new long[n][61];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dpMatrix[0][30 - array[0]] += 1;
        dpMatrix[0][30 + array[0]] += 1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 10; j <= 50; j++) {

                if (dpMatrix[i][j] != 0) {
                    dpMatrix[i + 1][j - array[i + 1]] += dpMatrix[i][j];
                    dpMatrix[i + 1][j + array[i + 1]] += dpMatrix[i][j];
                }

            }
        }


        System.out.print(dpMatrix[n - 1][m + 30]);



        

    }


}