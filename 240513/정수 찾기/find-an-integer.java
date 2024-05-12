import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            hashSet.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            sb.append(hashSet.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
        }

        System.out.print(sb);


    }





}