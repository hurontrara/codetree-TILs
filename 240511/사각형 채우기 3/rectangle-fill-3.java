import java.io.*;


public class Main {

    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 2;

        // logic + print
        System.out.print(memo(n));



    }

    static long memo(int index) {

        if (dp[index] != 0) {
            return dp[index];
        }

        long value = 0;
        for (int i = 0; i < index; i++) {

            if (i == index - 2) {
                value += (3 * memo(i)) % 1000000007;
            } else {
                value += (2 * memo(i)) % 1000000007;
            }

        }
        dp[index] = value % 1000000007;

        return dp[index];


    }


}