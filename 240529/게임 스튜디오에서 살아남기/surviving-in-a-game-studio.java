import java.io.*;
import java.util.*;


public class Main {

    static int n;

    static long[][] dpMatrix;

    static int c = (int) 1e9 + 7;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        dpMatrix = new long[n + 1][4];

        // init
        dpMatrix[0][0] = 1;

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j < 3; j++) {

                if (dpMatrix[i][j] == 0)
                    continue;

                long value = 0;
                value += (dpMatrix[i][j] * 2) % c;
                value -= (existCheck(i - 2, j) ? 1 : 0) % c;
                dpMatrix[i + 1][j] += value % c;

                dpMatrix[i + 1][j + 1] += dpMatrix[i][j] % c;


            }
        }

        long answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += dpMatrix[n][i] % c;
        }
        System.out.print(answer % c);



    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && dpMatrix[row][col] > 0;
    }


}