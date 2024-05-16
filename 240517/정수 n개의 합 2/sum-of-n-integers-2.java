import java.io.*;
import java.util.*;


public class Main {

    static int n, k; // n개의 원소, k개의 원소합

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] array;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        array = new int[n + 1];

        // 누적합
        st = new StringTokenizer(br.readLine());

        array[0] = 0;
        array[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i < n + 1; i++) {

            array[i] = array[i - 1] + Integer.parseInt(st.nextToken());

        }

        // 출력
        int answer = 0;
        for (int i = k; i < n; i++) {

            answer = Math.max(answer, array[i] - array[i - k]);

        }
        System.out.print(answer);





    }




}