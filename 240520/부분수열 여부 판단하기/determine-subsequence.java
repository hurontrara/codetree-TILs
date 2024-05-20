import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    static int[] aArray;
    static int[] bArray;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        aArray = new int[n]; bArray = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bArray[i] = Integer.parseInt(st.nextToken());
        }


        int pointer = 0;
        for (int i = 0; i < n; i++) {

            if (aArray[i] == bArray[pointer]) {

                pointer++;

            }

            if (pointer == m) {
                System.out.print("Yes");
                System.exit(0);
            }

        }
        System.out.print("No");


    }


}