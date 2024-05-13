import java.io.*;
import java.util.*;


public class Main {

    static int size;

    static int answer = Integer.MAX_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());

        treeSet.add(0);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {

            int value = Integer.parseInt(st.nextToken());

            treeSet.add(value);

            answer = Math.min(answer, treeSet.higher(value) != null ? treeSet.higher(value) - value : Integer.MAX_VALUE);
            answer = Math.min(answer, treeSet.lower(value) != null ? value - treeSet.lower(value) : Integer.MAX_VALUE);

            sb.append(answer).append("\n");


        }

        System.out.print(sb);


    }


}