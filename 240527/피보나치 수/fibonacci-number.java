import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;

    static long[] dpArray;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        dpArray = new long[n + 1];

        dpArray[1] = 1;
        dpArray[2] = 1;

        System.out.print(dp(n));



    }

    static long dp(int index) {

        if (dpArray[index] != 0)
            return dpArray[index];

        
        dpArray[index] = dpArray[index - 1] + dpArray[index] - 2;

        return dpArray[index];

    }




}