import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static HashSet<Integer> firstSet = new HashSet<>();
    static HashSet<Integer> secondSet = new HashSet<>();

    static int intersect = 0;


    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            firstSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            secondSet.add(Integer.parseInt(st.nextToken()));
        }

        // 교집합 갯수 구하기
        for (int firstValue : firstSet) {

            if (secondSet.contains(firstValue)) 
                intersect++;

        }

        System.out.print(firstSet.size() + secondSet.size() - 2 * intersect);


    }


}