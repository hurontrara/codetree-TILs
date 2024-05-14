import java.io.*;
import java.util.*;


public class Main {

    static int n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            int order = Integer.parseInt(br.readLine());

            if (order == 0) {

                if (pq.isEmpty()) {

                    sb.append(0).append("\n");

                } else {

                    sb.append(pq.poll()).append("\n");

                }


            } else {

                pq.add(order);

            }


        }     

        System.out.print(sb);   
    



    }





}