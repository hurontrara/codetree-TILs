import java.io.*;
import java.util.*;


public class Main {

    static int n, m; // n개의 숫자, m개의 쿼리

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] array;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {

            int input = Integer.parseInt(br.readLine());

            int left = 0; int right = n - 1;
            int mid = 0;
            while (left <= right) {

                mid = (left + right) / 2;

                if (array[mid] == input) {
                    break;
                }
                
                if (array[mid] < input)
                    left = mid + 1;
                else 
                    right = mid - 1;


            }

            if (array[mid] == input)
                sb.append(mid + 1).append("\n");
            else
                sb.append(-1).append("\n");

        }
        

        System.out.print(sb);


    }



}