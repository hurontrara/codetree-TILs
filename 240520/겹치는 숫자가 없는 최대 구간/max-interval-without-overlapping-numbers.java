import java.io.*;
import java.util.*;

public class Main {

    static int n;

    static int[] array;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }


        int left = 0;
        int answer = 1;
        hashSet.add(array[0]);

        for (int right = 1; right < n; right++) {

            // right의 값을 가지지 않을 때 까지 left 전진
            int value = array[right];

            while (hashSet.contains(value)) {

                hashSet.remove(array[left++]);

            }

            hashSet.add(value);
            answer = Math.max(answer, right - left + 1);


        }
        System.out.print(answer);



    }


}