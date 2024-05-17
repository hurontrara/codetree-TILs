import java.io.*;
import java.util.*;

public class Main {

    static int n, q; // n개의 점, q개의 질의

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int arraySize = 1000000;

    static int[] array = new int[arraySize + 1];
    static int[] countArray = new int[arraySize + 1];

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[Integer.parseInt(st.nextToken())] = 1;
        }

        for (int i = 1; i < arraySize + 1; i++) {

            if (array[i] == 1) 
                countArray[i] = countArray[i - 1] + 1;
            else
                countArray[i] = countArray[i - 1];

        }


        int answer = 0;
        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken());

            answer = countArray[end] - countArray[start];

            sb.append(answer).append("\n");
            
        }

        System.out.print(sb);


    }



}