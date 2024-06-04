import java.io.*;
import java.util.*;


public class Main {

    static int n, m;

    static int[] array;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            array[i] = a;
            hashSet.add(a);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {

            int input = Integer.parseInt(st.nextToken());

            if (!hashSet.contains(input)) {
                sb.append("-1 \n");
                continue;
            }

            int left = 0; int right = n - 1;
            int idx = n;
            while (left <= right) {

                int mid = (left + right) / 2;

                if (array[mid] >= input) {

                    right = mid - 1;
                    idx = Math.min(idx, mid);

                }
                else {

                    left = mid + 1;

                }


            }
            sb.append(idx + 1).append("\n");



        }
        System.out.print(sb);


    }


}