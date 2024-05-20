import java.io.*;
import java.util.*;


public class Main {

    static int n;

    static int[] array;
    static long[] sumArray;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        array = new int[n]; sumArray = new long[n + 1];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }


        sumArray[0] = 0; 
        for (int i = 1; i < n + 1; i++) {
            sumArray[i] = sumArray[i - 1] + array[i - 1];
        }

        int answer = 0;
        hashMap.put(0, 0);
        for (int i = 1; i < n + 1; i++) {

            int value = (int) (sumArray[i] % 7);

            if (!hashMap.containsKey(value)) {
                hashMap.put(value, i);
            }

            answer = Math.max(answer, i - hashMap.get(value));

        }

        System.out.print(answer);

    }

}