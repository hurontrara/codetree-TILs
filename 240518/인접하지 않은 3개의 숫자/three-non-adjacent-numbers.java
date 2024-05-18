import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] array;

    static int[] lMax;
    static int[] rMax;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        array = new int[n]; lMax = new int[n]; rMax = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        lMax[0] = array[0]; rMax[n - 1] = array[n - 1];

        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], array[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], array[i]);
        }

        int answer = 0;
        for (int mid = 2; mid < n - 2; mid++) {

            answer = Math.max(answer, lMax[mid - 2] + rMax[mid + 2] + array[mid]);

        }
        System.out.print(answer);




    }



}