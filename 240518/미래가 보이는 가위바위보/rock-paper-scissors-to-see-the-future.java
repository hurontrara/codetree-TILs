import java.io.*;
import java.util.*;


public class Main {

    static int n;

    static String[] array;

    static int[] hArray, sArray, pArray;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        array = new String[n + 1];

        hArray = new int[n + 1]; sArray = new int[n + 1]; pArray = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            array[i] = br.readLine();

        }

        for (int i = 1; i <= n; i++) {

            hArray[i] = hArray[i - 1];
            sArray[i] = sArray[i - 1];
            pArray[i] = pArray[i - 1];

            String input = array[i];
            if (input.equals("P"))
                sArray[i] += 1;
            else if (input.equals("H"))
                pArray[i] += 1;
            else
                hArray[i] += 1;

        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {

            // i번째에 바꾸는 경우
            int first = 0;
            first = Math.max(first, hArray[i]);
            first = Math.max(first, sArray[i]);
            first = Math.max(first, pArray[i]);


            int second = 0;
            second = Math.max(second, hArray[n] - hArray[i]);
            second = Math.max(second, sArray[n] - sArray[i]);
            second = Math.max(second, pArray[n] - pArray[i]);

            answer = Math.max(answer, first + second);
 


        }
        System.out.print(answer);



        


    }


}