import java.io.*;
import java.util.*;


public class Main {

    static int n;
    static int[] array;
    static int[] dpMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        array = new int[n]; dpMatrix = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dpMatrix[0] = array[0];
        for (int i = 1; i < n; i++) {

            int a = array[i];
            int b = dpMatrix[i - 1] + array[i];

            dpMatrix[i] = Math.max(a, b);

        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dpMatrix[i]);
        }
        System.out.print(answer);
        



    }
}