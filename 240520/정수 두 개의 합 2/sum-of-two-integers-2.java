import java.io.*;
import java.util.*;


public class Main {

    static int n, m; // n개의 원소, 합이 m보다 작은

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] array;

    static TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // value, index
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int idx = 0;
        for (int value : array) {
            treeMap.put(value, idx++);
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }

        int answer = 0;
        for (int value : hashMap.keySet()) {

            Integer lowerKey = treeMap.lowerKey(Math.min(m - value + 1, value));

            if (lowerKey == null)
                continue;

            answer += hashMap.get(value) * (treeMap.get(lowerKey) + 1);


        }
        System.out.print(answer);




    }


}