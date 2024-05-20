import java.io.*;
import java.util.*;

public class Main {

    static int n, s; // n개의 값, 합이 s 이상

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] array;
    static int[] sumArray;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); s = Integer.parseInt(st.nextToken());
        array = new int[n]; sumArray = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            array[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 1; i < n + 1; i++) {

            sumArray[i] = sumArray[i - 1] + array[i - 1];

        }


        int left = 0;
        int right = 0;
        for (int i = 1; i < n + 1; i++) {
            if (sumArray[i] >= s) {
                right = i;
                break;
            }
        }
        if (right == 0) {
            System.out.print(-1);
            System.exit(0);
        }


        int answer = Integer.MAX_VALUE;
        for (int j = right; j < n + 1; j++) {

            int allSum = sumArray[j];

            // left를 최대한 땡겨보기

            while (true) {

                if (allSum - sumArray[left + 1] >= s)
                    left++;
                else
                    break;

            }

            answer = Math.min(answer, j - left);


        }
        System.out.print(answer);





    }
}

// long 타입 사용