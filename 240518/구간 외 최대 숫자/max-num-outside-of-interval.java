import java.io.*;
import java.util.*;


public class Main {

    static int n, q;

    static int[] array;

    static int[] leftMax;
    static int[] rightMax;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());
        array = new int[n]; leftMax = new int[n]; rightMax = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            array[i] = Integer.parseInt(st.nextToken());

        }

        leftMax[0] = array[0];
        for (int i = 1; i < n; i++) {

            leftMax[i] = Math.max(leftMax[i - 1], array[i]);

        }

        rightMax[n - 1] = array[n - 1];
        for (int i = n - 2; i >= 0; i--) {


            rightMax[i] = Math.max(rightMax[i + 1], array[i]);

        }

        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());
            int answer = 0;

            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

            if (a != 1) {
                answer = Math.max(answer, leftMax[a - 2]);
            }

            if (b != n) {

                answer = Math.max(answer, rightMax[b]);
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);







    }


}