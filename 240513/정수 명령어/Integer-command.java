import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Integer> treeSet = new TreeSet<>();

    static int time;
    static int n;

    public static void main(String[] args) throws Exception {

        time = Integer.parseInt(br.readLine());

        for (int t = 0; t < time; t++) {

            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {

                st = new StringTokenizer(br.readLine());
                String order = st.nextToken(); int value = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {

                    treeSet.add(value);

                } else if (value == 1 && !treeSet.isEmpty()) {

                    treeSet.remove(treeSet.last());

                } else if (value == -1 && !treeSet.isEmpty()) {

                    treeSet.remove(treeSet.first());

                }


            }

            // 출력
            if (!treeSet.isEmpty()) {
                sb.append(treeSet.last()).append(" ").append(treeSet.first());
            } else {
                sb.append("EMPTY");
            }

            sb.append("\n");

            treeSet.clear();



        }

        System.out.print(sb);


    }



}