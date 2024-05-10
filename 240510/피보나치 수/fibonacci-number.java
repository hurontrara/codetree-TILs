import java.io.*;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); dp = new int[n + 1]; // 인덱스 1에 첫번째 저장
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 1;
        }


        // logic
        memo(n);

        // print
        System.out.print(dp[n]);




    }

    static int memo(int index) {

        if (dp[index] != 0)
            return dp[index];

        dp[index] = memo(index - 1) + memo(index - 2);

        return dp[index];

    }
}