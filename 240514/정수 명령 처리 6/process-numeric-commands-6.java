import java.io.*;
import java.util.*;


public class Main {

    static int size;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {

            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {

                case "push":

                    pq.add(-Integer.parseInt(st.nextToken()));
                    break;

                case "size":

                    sb.append(pq.size()).append("\n");
                    break;

                case "pop":
                    sb.append(-pq.poll()).append("\n");
                    break;

                case "empty":
                    sb.append(pq.size() == 0 ? 1 : 0).append("\n");
                    break;
            
                case "top":
                    sb.append(-pq.peek()).append("\n");
                    break;



            }


        }

        System.out.print(sb);

    }




}