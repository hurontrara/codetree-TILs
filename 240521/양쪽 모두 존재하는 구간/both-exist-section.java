import java.io.*;
import java.util.*;

public class Main {

    static int n, m; // n 길이의 배열, m 이하의 숫자

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static HashMap<Integer, Integer> globalHashMap = new HashMap<>(); // value : count
    static HashMap<Integer, Integer> localHashMap = new HashMap<>();

    static int[] array;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            globalHashMap.put(input, globalHashMap.getOrDefault(input, 0) + 1);
            array[i] = input;
        }

        // 가지치기
        if (array.length == 1) {
            System.out.print(-1);
            System.exit(0);
        }

        for (int value : globalHashMap.values()) {
            if (value < 2) {
                System.out.print(-1);
                System.exit(0);
            }
        }


        int answer = Integer.MAX_VALUE;
        int left = 0;
        localHashMap.put(array[0], 1);
        for (int right = 1; right < n; right++) {

            localHashMap.put(array[right], localHashMap.getOrDefault(array[right], 0) + 1);

            while (localHashMap.get(array[right]) == globalHashMap.get(array[right])) {

                localHashMap.put(array[left], localHashMap.get(array[left]) - 1);

                if (localHashMap.get(array[left]) == 0)
                    localHashMap.remove(array[left]);

                left++;

            }

            // 압축
            while (localHashMap.get(array[left]) > 1) {

                localHashMap.put(array[left], localHashMap.get(array[left]) - 1);

                if (localHashMap.get(array[left]) == 0)
                    localHashMap.remove(array[left]);

                left++;

            }


            // 체크(size)
            if (localHashMap.size() == m)
                answer = Math.min(answer, right - left + 1);




        }
        System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);




    }


}