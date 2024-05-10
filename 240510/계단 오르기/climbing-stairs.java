import java.io.*;


public class Main {

    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); dp = new long[n + 1]; // 1번째 값에 1번째 인덱스

        dp[2] = 1;
        if (n >= 3)
            dp[3] = 1;

        // logic
        long answer = memo(n);
        System.out.print(answer % 10007);




    }


    static long memo(int index) {

        if (dp[index] != 0 || index < 2) {
            return dp[index];
        }

        dp[index] = (memo(index - 2) + memo(index - 3)) % 10007;

        return dp[index];



    }


}