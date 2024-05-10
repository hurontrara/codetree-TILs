import java.io.*;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); dp = new int[n]; 

        dp[0] = 1;
        if (n >= 2)
            dp[1] = 2;


        // logic
        int answer = memo(n - 1);
        System.out.print(answer);



    }
    
    static int memo(int index) {

        if (dp[index] != 0) {
            return dp[index];
        }

        dp[index] = (memo(index - 1) + memo(index - 2)) % 10007;

        return dp[index];



    }


}