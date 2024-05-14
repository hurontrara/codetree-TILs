import java.io.*;
import java.util.*;


public class Main {

    static int n, m; // n개의 숫자, m번의 연산

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 음수인 채로 큐에 삽입
        for (int i = 0; i < n; i++) {

            int value = Integer.parseInt(st.nextToken()) * -1;
            pq.add(value);

        }


        // 하나 빼서 더하기 1하고 다시 넣기
        for (int i = 0; i < m; i++) {

            int value = pq.poll();
            value++;
            pq.add(value);


        }

        // 최댓값 출력
        System.out.print(pq.poll() * -1);



    }




}