import java.io.*;
import java.util.*;


public class Main {

    static int n;
    static int[] array;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        array = new int[100000 + 1];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

            array[a] = 1; array[b] = -1;


        }

        int answer = 0;
        int sum = 0;
        for (int i = 0; i < 100000; i++) {

            sum += array[i];
            answer = Math.max(answer, sum);

        }
        System.out.print(answer);


    }


}