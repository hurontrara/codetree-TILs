import java.io.*;
import java.util.*;

public class Main {

    static int n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static TreeSet<Integer> treeSet = new TreeSet<>();

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            int input = Integer.parseInt(st.nextToken());
            treeSet.add(input);
            hashMap.put(input, hashMap.getOrDefault(input, 0) + 1); 

        }

        int answer = Integer.MAX_VALUE;
        for (int value : treeSet) {

            int reverseValue = value * -1;

            Integer a = treeSet.ceiling(reverseValue);
            Integer b = treeSet.floor(reverseValue);



            if (a != null && (a != value || hashMap.get(value) >= 2))
                answer = Math.min(answer, Math.abs(value + a));

            if (b != null && (b != value || hashMap.get(value) >= 2))
                answer = Math.min(answer, Math.abs(value + b));

        }
        System.out.print(answer);



    }



}