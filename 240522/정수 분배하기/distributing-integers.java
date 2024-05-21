import java.io.*;
import java.util.*;

public class Main {

    static int n, m; // n개의 정수를 분배하여 m개를 만들려고 함

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] array;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        // 작거나 같은 것 중에서 최댓값
        int left = 1; int right = array[0]; // left = 1, right = 457
        int idx = 0;
        while (left <= right) {

            int mid = (left + right) / 2;

            int count = 0;
            for (int value : array) {
                count += value / mid;
            }

            if (count >= m) {
                left = mid + 1;
                idx = Math.max(idx, mid);
            }
            else {
                right = mid - 1;
            }

        }
        System.out.print(idx);








    }


}