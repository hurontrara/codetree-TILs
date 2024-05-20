import java.io.*;
import java.util.*;

public class Main {

    static int n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            treeSet.add(Integer.parseInt(st.nextToken()));

        }

        int answer = Integer.MAX_VALUE;
        for (int value : treeSet) {

            int reverseValue = value * -1;

            Integer a = treeSet.ceiling(reverseValue);
            Integer b = treeSet.floor(reverseValue);

            if (a != null)
                answer = Math.min(answer, Math.abs(value + a));

            if (b != null)
                answer = Math.min(answer, Math.abs(value + b));

        }
        System.out.print(answer);



    }



}