import java.io.*;
import java.util.*;

public class Main {

    static int n, k; 

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] array;
    static int[] sumArray;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        array = new int[n]; sumArray = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            array[i] = Integer.parseInt(st.nextToken());

        }

        // 누적합 생성
        sumArray[0] = array[0] == 1 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            sumArray[i] = sumArray[i - 1] + (array[i] == 1 ? 1 : 0);
        }

        // 가지치기
        if (sumArray[n - 1] < k) {
            System.out.print(-1);
            System.exit(0);
        }

        if (k == 1) {
            System.out.print(1);
            System.exit(0);
        }


        int left = 0;
        int right = 0;
        boolean leftIsFixed = false;
        for (int i = 0; i < n; i++) {

            if (!leftIsFixed && sumArray[i] == 1) {
                left = i;
                leftIsFixed = true;
            }
            else if (sumArray[i] == k) {

                right = i;
                break;

            }

        }

        int answer = right - left + 1;
        for (int j = right + 1; j < n; j++) {

            if (array[j] == 1) {

                left++;
                while (array[left] != 1) {
                    left++;
                }

            }

            answer = Math.min(answer, j - left + 1);

        }
        System.out.print(answer);






    }
}