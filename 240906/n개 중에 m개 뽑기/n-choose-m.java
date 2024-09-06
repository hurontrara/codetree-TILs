import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<Integer> list = new ArrayList<>();

    static int n, m;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {

            combination(i);

        }

        System.out.println(sb);


    }

    static void combination(int idx) {

        if (idx == n && list.size() == m) {

            for (int value : list) {
                
                sb.append(value).append(" ");

            }

            sb.append("\n");


            return;

        }


        if (idx == n || list.size() == m)
            return;

        
        list.add(idx + 1);
        for (int i = idx + 1; i <= n; i++) {

            combination(i);


        }
        list.remove(list.size() - 1);




    }

}