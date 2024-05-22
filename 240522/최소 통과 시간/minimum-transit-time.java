import java.io.*;
import java.util.*;


public class Main {

    static int n, m; // n개의 물건, m개의 통로

    static int[] gateArray;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        gateArray = new int[m];

        for (int i = 0; i < m; i++) {
            gateArray[i] = Integer.parseInt(br.readLine());
        }

        // 시간에 대하여 left , right
        long left = 1; long right = (long) Integer.MAX_VALUE * 50000;
        long answer = Long.MAX_VALUE;
        while (left <= right) {

            long mid = (left + right) / 2;

            // 시간에 대하여 얼마나 커버할 수 있는지...
            long cnt = 0;
            for (int value : gateArray) {
                cnt += mid / value;
            }

            if (cnt >= n) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
            else {
                left = mid + 1;
            }


        }
        System.out.print(answer);



    }


}