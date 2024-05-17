import java.io.*;
import java.util.*;

public class Main {

    static int size, k; // size개의 정수, 합이 k인 것의 갯수

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] sumArray;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        sumArray = new int[size + 1]; sumArray[0] = 0;


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {

            sumArray[i] = sumArray[i - 1] + Integer.parseInt(st.nextToken());

        }

        int answer = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {

                if (sumArray[i] - sumArray[j] == k)
                    answer++;

            }
        }

        System.out.print(answer);


    }


}