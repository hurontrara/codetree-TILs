import java.io.*;
import java.util.*;

class Knight {

    int number;
    Knight prev = null;
    Knight next = null;

    Knight(int number) {
        this.number = number;
    }

}


public class Main {

    static int n, m; // 기사의 수 n , 부르는 기사 수 m

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashMap<Integer, Knight> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Knight left = new Knight(Integer.parseInt(st.nextToken())); hashMap.put(left.number, left);
        Knight first = left;
        Knight present = null;
        for (int i = 1; i < n; i++) {

            present = new Knight(Integer.parseInt(st.nextToken()));
            hashMap.put(present.number, present);

            left.next = present; present.prev = left;
            left = present;

        }

        // 원탁이므로 끝을 이어줘야함
        present.next = first; first.prev = present;


        for (int i = 0; i < m; i++) {

            int order = Integer.parseInt(br.readLine());

            Knight orderKnight = hashMap.get(order);

            sb.append(orderKnight.next.number).append(" ").append(orderKnight.prev.number).append("\n");

            orderKnight.prev.next = orderKnight.next; orderKnight.next.prev = orderKnight.prev;
            orderKnight.prev = null; orderKnight.next = null;


        }

        System.out.print(sb);

        
    }



}