import java.io.*;
import java.util.*;

public class Main {

    static int n, k, b; // n 까지의 숫자, b개의 숫자 빠짐, 연속한 k개의 숫자

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] array;
    static int[] zeroCountArray;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken());
    
        array = new int[n + 1]; zeroCountArray = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            array[i] = i;
        }

        for (int i = 0; i < b; i++) {
            array[Integer.parseInt(br.readLine())] = 0;
        }

        for (int i = 1; i < n + 1; i++) {

            if (array[i] == 0)
                zeroCountArray[i] = zeroCountArray[i - 1] + 1;
            else
                zeroCountArray[i] = zeroCountArray[i - 1];

        }

        int answer = Integer.MAX_VALUE;
        for (int i = k; i < n + 1; i++) {

            int need = zeroCountArray[i] - zeroCountArray[i - k];
            answer = Math.min(answer, need);


        }

        System.out.print(answer);

        


    }


}