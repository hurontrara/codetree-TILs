import java.io.*;

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

        dp[index] = (memo(index - 2) * 2 + memo(index - 1)) % 10007;

        return dp[index]; 


    }

}