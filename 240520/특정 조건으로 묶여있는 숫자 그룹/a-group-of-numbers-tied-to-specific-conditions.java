import java.io.*;
import java.util.*;


public class Main {

    static int n, k; // n개의 숫자, k 이내

    static int[] array;
    static int[] saved;
    static int[] maxArray;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        array = new int[n]; saved = new int[n]; maxArray = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int left = 0;
        for (int right = 0; right < n; right++) {

            while (array[right] - array[left] > k) {
                left++;
            }

            saved[right] = right - left + 1;

        }

        // saved = [1, 2, 1, 2, 1, 2, 3, 2]
        // 최댓값 기록
        int max = saved[0];
        for (int i = 0; i < n; i++) {

            max = Math.max(max, saved[i]);

            maxArray[i] = max;

        }

        // max = [1, 2, 2, 2, 2, 2, 3, 3]
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {

            int count = 0;
            count += saved[i];

            int newIndex = i - saved[i];

            if (newIndex >= 0) {

                count += maxArray[newIndex];

            }

            answer = Math.max(answer, count);

        }
        System.out.print(answer);



    }




}