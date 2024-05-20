import java.io.*;
import java.util.*;


public class Main {

    static int n, m; // 크기가 n, 원소합이 m
    static int[] array;
    static long[] sumArray;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        array = new int[n]; sumArray = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            array[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 1; i < n + 1; i++) {

            sumArray[i] = sumArray[i - 1] + array[i - 1];

        }

        int answer = 0;
        int left = 0;
        for (int right = 1; right < n + 1; right++) {

            // 합이 m보다 작거나 같음을 보장
            while (sumArray[right] - sumArray[left] > m) {
                left++;
            }

            if (sumArray[right] - sumArray[left] == m)
                answer++;


        }
        System.out.print(answer);

    }

}

// long 타입 사용