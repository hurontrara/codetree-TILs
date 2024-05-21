import java.io.*;
import java.util.*;


public class Main {

    static long m; // 1이상 m 이하의 수 중 하나 선택
    static long start; // 컴퓨터 입장에서 선택
    static long end; // 컴퓨터 입장에서 선택

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        m = Long.parseLong(br.readLine());

        st = new StringTokenizer(br.readLine());
        start = Long.parseLong(st.nextToken()); end = Long.parseLong(st.nextToken());


        int maxCount = Integer.MIN_VALUE;
        int minCount = Integer.MAX_VALUE;
        for (long input = start; input <= end; input++) {

            int round = 1;
            long left = 1; long right = m;
            while (left <= right) {

                long mid = (left + right) / 2;

                if (mid == input) {
                    maxCount = Math.max(round, maxCount);
                    minCount = Math.min(round, minCount);

                    break;
                }

                if (mid > input) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }

                round++;

            }


        }
        System.out.print(minCount + " " + maxCount);



    }
}

// long 타입 사용