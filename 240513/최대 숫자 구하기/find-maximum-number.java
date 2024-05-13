import java.io.*;
import java.util.*;


public class Main {

    static int n, m;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= m; i++) {
            treeSet.add(i);
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());

            treeSet.remove(value);

            sb.append(treeSet.last()).append("\n");
        }

        System.out.print(sb);



    }




}