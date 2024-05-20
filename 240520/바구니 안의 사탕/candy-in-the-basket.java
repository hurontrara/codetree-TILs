import java.io.*;
import java.util.*;

public class Main {

    static int n, k; // n개의 바구니, 구간 k
    static long[] array;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        array = new long[1000000 + 1];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken()); int position = Integer.parseInt(st.nextToken());

            array[position] += count;


        }

        long answer = 0;
        long cnt = 0;
        for (int right = 0; right < array.length; right++) {

            int left = right - 2 * k;

            cnt += array[right];

            answer = Math.max(answer, cnt);

            if (left >= 0)
                cnt -= array[left];

        }
        System.out.print(answer);


    }




}