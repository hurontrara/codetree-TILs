import java.io.*;
import java.util.*;


public class Main {

    static int n, m; // 0 ~ n까지의 수열, m개의 인풋

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {

            int answer = 0;

            int start = 0;

            treeSet.add(Integer.parseInt(st.nextToken()));

            for (int value : treeSet) {

                int end = value;

                answer = Math.max(answer, end - start);

                start = end + 1;

            }

            answer = Math.max(answer, n - start + 1);

            sb.append(answer).append("\n");


        }

        System.out.print(sb);


    }


}