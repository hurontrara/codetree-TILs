import java.io.*;
import java.util.*;

public class Main {

    static int n, m; // n 개의 불, m 개의 소방서

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] nArray;
    static int[] mArray;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        nArray = new int[n]; mArray = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArray); Arrays.sort(mArray);

        int store = 0;
        int answer = 0;
        for (int fire = 0; fire < n; fire++) {

            int firePlace = nArray[fire];

            while (store < m - 1 && Math.abs(firePlace - mArray[store]) > Math.abs(firePlace - mArray[store + 1])) {
                store++;
            }

            answer = Math.max(answer, Math.abs(mArray[store] - firePlace));


        }
        System.out.print(answer);


    }


}