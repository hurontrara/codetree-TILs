import java.io.*;
import java.util.*;


public class Main {

    static int n, m; // n개의 숫자, m개의 쿼리

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashSet<Integer> hashSet = new HashSet<>();

    static int[] array;

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


        for (int i = 0; i < m; i++) {

            int input = Integer.parseInt(br.readLine());

            // 하나 이상 들어있음을 보장
            if (!hashSet.contains(input)) {
                sb.append("0 \n");
                continue;
            }

            int upperBoundIndex = getUpperBoundIndex(input);
            int lowerBoundIndex = getLowerBoundIndex(input);

            sb.append(upperBoundIndex - lowerBoundIndex).append("\n");

        }

        System.out.print(sb);

    }

    static int getUpperBoundIndex(int input) {

        int left = 0; int right = n - 1;
        int idx = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (array[mid] <= input) {

                left = mid + 1;
                idx = Math.max(idx, mid);

            }

            else
                right = mid - 1;


        }

        return idx;


    }

    static int getLowerBoundIndex(int input) {

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




}