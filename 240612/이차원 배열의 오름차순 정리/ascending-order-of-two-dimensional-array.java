import java.io.*;
import java.util.*;

public class Main {

    static int n, k; // n * n 의 행렬, k번째 오는 수

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine()); k = Integer.parseInt(br.readLine());

        if (k == 1) {
            System.out.print(1);
            System.exit(0);
        }

        long left = 1; long right = (long) Math.min(Math.pow(10, 9), Math.pow(n, 2));
        long idx = right;
        while (left <= right) {

            long mid = (left + right) / 2;

            // mid가 몇 번째인지
            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (count >= k) {
                idx = Math.min(idx, mid);
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }


        }
        System.out.print(idx);


    }





}