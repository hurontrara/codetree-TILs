import java.io.*;
import java.util.*;


public class Main {

    static int n, m; // n개의 점 , 4개의 선분(쿼리)

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] array;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

            // 작은 것 중에 가장 큰 것
            // 작거나 같은 것 중에 가장 큰 것

            int first = getLowerBound(a);
            int second = getUpperBound(b);

            sb.append(second - first).append("\n");

        }
        System.out.print(sb);


    }

    static int getLowerBound(int input) {

        int left = 0; int right = n - 1;

        int idx = -1;
        while (left <= right) {

            int mid = (left + right) / 2;

            if (array[mid] < input) {

                left = mid + 1;
                idx = Math.max(idx, mid);

            }
            else {
                right = mid - 1;
            }


        }
        return idx;

    }

    static int getUpperBound(int input) {

        int left = 0; int right = n - 1;

        int idx = -1;
        while (left <= right) {

            int mid = (left + right) / 2;

            if (array[mid] <= input) {

                left = mid + 1;
                idx = Math.max(idx, mid);

            }
            else {
                right = mid - 1;
            }


        }
        return idx;


    }



}