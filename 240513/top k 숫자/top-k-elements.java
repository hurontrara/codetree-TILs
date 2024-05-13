import java.io.*;
import java.util.*;

public class Main {

    static int n, k;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {

            treeSet.add(Integer.parseInt(st.nextToken()) * -1);

        }

        int idx = 0;
        for (int value : treeSet) {

            if (idx == k)
                break;
            

            sb.append(value * - 1).append(" ");

            idx++;
        }

        System.out.print(sb);



    }



}