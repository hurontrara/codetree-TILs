import java.io.*;
import java.util.*;


public class Main {

    static int n;

    static int[][][] dpMatrix;

    static int MOD = (int) 1e9 + 7;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        dpMatrix = new int[n + 1][3 + 1][3 + 1]; // 0, 1, 2 안에서만 돎 (두번째가 T, 세번째가 B)

        
        // init
        dpMatrix[1][0][0] = 1; dpMatrix[1][1][0] = 1; dpMatrix[1][0][1] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {

                    if (dpMatrix[i][j][k] != 0) {

                        dpMatrix[i + 1][j][0] += dpMatrix[i][j][k];
                        dpMatrix[i + 1][j + 1][0] += dpMatrix[i][j][k];
                        dpMatrix[i + 1][j][k + 1] += dpMatrix[i][j][k];


                        dpMatrix[i + 1][j][0] %= MOD;
                        dpMatrix[i + 1][j + 1][0] %= MOD;
                        dpMatrix[i + 1][j][k + 1] %= MOD;

                    }



                }
            }
        }

        int answer = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                answer += dpMatrix[n][j][k];
                answer %= MOD;
            }
        }
        System.out.print(answer);



    }


}