import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<Integer> list = new ArrayList<>();

    static int k, n;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        
        k = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
        
        backTracking();

        System.out.println(sb);


    }

    static void backTracking() {

        if (list.size() == n) {

            for (int value : list) {

                sb.append(value).append(" ");

            }

            sb.append("\n");

            return;
        }


        for (int i = 1; i <= k; i++) {

            list.add(i);

            backTracking();

            list.remove(list.size() - 1);

        }



    }





}