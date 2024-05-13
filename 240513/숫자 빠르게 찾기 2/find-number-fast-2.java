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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {

            int input = Integer.parseInt(br.readLine());

            Integer value = treeSet.ceiling(input);

            sb.append(value != null ? value : -1).append("\n");


        }

        System.out.print(sb);




    }





}