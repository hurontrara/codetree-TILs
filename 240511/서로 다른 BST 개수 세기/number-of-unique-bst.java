import java.io.*;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); dp = new int[n + 1];

        dp[0] = 1; dp[1] = 1;
        // logic
        System.out.print(memo(n));




    }

    static int memo(int index) {

        if (dp[index] != 0) {
            return dp[index];
        }

        int value = 0;

        for (int i = 0; i < index; i++) {

            value += memo(i) * memo(index - i - 1);

        }
        dp[index] = value;

        return dp[index];


    }



}