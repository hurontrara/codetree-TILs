import java.io.*;
import java.util.*;

public class Main {

    static int n;

    static char[] inputArray;

    static int[] cCount;
    static int[] wCount;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        cCount = new int[n]; wCount = new int[n];

        inputArray = br.readLine().toCharArray();

        // 초기화
        if (inputArray[0] == 'C') {
            cCount[0] = 1;
        }
        if (inputArray[n - 1] == 'W')
            wCount[n - 1] = 1;

        
        for (int i = 1; i < n; i++) {

            cCount[i] = cCount[i - 1];

            if (inputArray[i] == 'C')
                cCount[i] += 1;

        }

        for (int i = n - 2; i >= 0; i--) {

            wCount[i] = wCount[i + 1];

            if (inputArray[i] == 'W')
                wCount[i] += 1;


        }


        long answer = 0;
        for (int i = 0; i < n; i++) {

            if (inputArray[i] == 'O')
                answer += (long) cCount[i] * (long) wCount[i];

        }
        System.out.print(answer);









    }


}