import java.io.*;
import java.util.*;

class Problem implements Comparable<Problem> {

    int number;
    int rating;

    Problem(int number, int rating) {
        this.number = number;
        this.rating = rating;
    }

    @Override
    public int compareTo(Problem problem) {

        if (this.rating == problem.rating)
            return this.number - problem.number;
        
        return this.rating - problem.rating;

    }

}


public class Main {

    static int n, m;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Problem> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()); int rating = Integer.parseInt(st.nextToken());
            treeSet.add(new Problem(number, rating));

        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("ad")) {

                treeSet.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

            } else if (order.equals("sv")) {

                
                treeSet.remove(treeSet.ceiling(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));

            } else {

                int dir = Integer.parseInt(st.nextToken());
                Problem point;
                if (dir == 1) {
                    point = treeSet.last();
                } else {
                    point = treeSet.first();
                }

                sb.append(point.number).append("\n");

            }

        }

        System.out.print(sb);


    }



}