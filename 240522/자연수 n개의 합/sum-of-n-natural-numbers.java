import java.io.*;
import java.util.*;

public class Main {

    static long n; // 합이 n 이하인 경우 중 가능한 n의 최대값

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        n = Long.parseLong(br.readLine());

        // 작거나 같은 것들 중 최대값
        long left = 1; long right = 2000000000;
        long maxValue = 0;
        while (left <= right) {

            long mid = (left + right) / 2;

            if (mid * (mid + 1) / 2 <= n) {

                left = mid + 1;
                maxValue = Math.max(maxValue, mid);

            }

            else {

                right = mid - 1;
            }

        }
        System.out.print(maxValue);

        



    }



}