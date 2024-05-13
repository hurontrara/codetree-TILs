import java.io.*;
import java.util.*;

public class Main {

    static int n, m; // n명의 사람, m개의 의자

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        // {1, 2, 3, 4}
        for (int i = 1; i <= m; i++) {
            treeSet.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {

            int value = Integer.parseInt(st.nextToken());

            if (treeSet.floor(value) != null) {

                treeSet.remove(treeSet.floor(value));
                cnt += 1;

            } else {

                System.out.print(cnt);
                System.exit(0);

            }

        }

        System.out.print(cnt);


    }



}