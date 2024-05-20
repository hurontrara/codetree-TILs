import java.io.*;
import java.util.*;

public class Main {

    static int n, k; // n개의 원소, k개 이하 허용

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static HashMap<Integer, Integer> hashMap = new HashMap<>(); // value : count

    static int[] array;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        if (array.length == 1) {
            System.out.print(1);
            System.exit(0);
        }

        int left = 0;
        hashMap.put(array[0], 1);
        int answer = 0;
        for (int right = 1; right < n; right++) {

            hashMap.put(array[right], hashMap.getOrDefault(array[right], 0) + 1);

            while (hashMap.get(array[right]) > k) {

                hashMap.put(array[left], hashMap.get(array[left]) - 1);
                left++; 

            }

            answer = Math.max(answer, right - left + 1);


        }
        System.out.print(answer);


    }


}