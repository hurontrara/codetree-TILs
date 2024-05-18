import java.io.*;
import java.util.*;


public class Main {

    static int n;

    static long total = 0;

    static int[] array;
    static long[] sumArray;

    static int[] firstCountArray;
    static int[] secondCountArray;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        array = new int[n]; sumArray = new long[n];
        firstCountArray = new int[n]; secondCountArray = new int[n];

        st = new StringTokenizer(br.readLine());

        // array + total
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            array[i] = input;
            total += input;
        }

        // 누적합
        sumArray[0] = array[0];

        for (int i = 1; i < n; i++) {
            sumArray[i] = sumArray[i - 1] + array[i];
        }

        // 3의 갯수 / 9의 갯수
        if (array[0] == total / 4)
            firstCountArray[0] = 1;
        if (array[0] == total / 4 * 3)
            secondCountArray[0] = 1;


        for (int i = 1; i < n; i++) {

            firstCountArray[i] = firstCountArray[i - 1];
            secondCountArray[i] = secondCountArray[i - 1];

            if (sumArray[i] == total / 4)
                firstCountArray[i] += 1;
            if (sumArray[i] == total / 4 * 3)
                secondCountArray[i] += 1;

        }

        long answer = 0;
        for (int i = 1; i < n - 2; i++) {

            if (sumArray[i] == total / 2) {

                answer += (long) firstCountArray[i - 1] * (long) (secondCountArray[n - 2] - secondCountArray[i]);

            }

        }
        System.out.print(answer);












    }




}