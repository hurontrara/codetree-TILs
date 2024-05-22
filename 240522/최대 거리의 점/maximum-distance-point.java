import java.io.*;
import java.util.*;


public class Main {

    static int n, m; // n개의 점 위에 m개의 물건 설치

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] array;

    static int MAX = 1000000000;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        // 적어도 하나는 놓아야한다는 것을 보장
        if (m == 2) {
            System.out.print(array[n - 1] - array[0]);
            System.exit(0);
        }

        int left = 1; int right = array[n - 1] - array[0];
        int answer = 0;

        // 최소 거리가 mid 일 때 몇 개 놓을 수 있는지를 생각
        while (left <= right) {

            int mid = (left + right) / 2;
            int leftSheet = array[0]; int rightSheet = array[n - 1];
            int count = 2;

            if (mid == 30516) {
                answer++;
            }

            for (int i = 1; i < n - 1; i++) {

                // leftSheet와의 거리
                int distance = Math.min(array[i] - leftSheet, rightSheet - array[i]);
                if (distance >= mid) {
                    leftSheet = array[i];
                    count++;
                    continue;
                }

            }



            if (count >= m) {
                // 거리를 키워야 함
                answer = Math.max(answer, mid);
                left = mid + 1;

            }
            else {
                right = mid - 1;
            }



        }
        System.out.print(answer);




    }


}