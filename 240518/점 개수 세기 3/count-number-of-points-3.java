import java.io.*;
import java.util.*;

public class Main {

    static int n, q; // n개의 점, q개의 쿼리

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st; 
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Integer> treeSet = new TreeSet<>();
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for (int value : treeSet) {
            treeMap.put(value, cnt);
            cnt++;
        }


        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int answer = treeMap.get(b) - treeMap.get(a) + 1;
            sb.append(answer).append("\n");


        }
        System.out.print(sb);


    }


}