import java.io.*;
import java.util.*;

class City {

    String name;
    City prev = null;
    City next = null;

    City(String name) {
        this.name = name;
    }

}


public class Main {

    static int n, m; // n개의 도시, m개의 연산

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        City leftCity = new City(st.nextToken());
        City cur = leftCity;
        City presentCity = null;
        for (int i = 1; i < n; i++) {

            presentCity = new City(st.nextToken());

            leftCity.next = presentCity;
            presentCity.prev = leftCity;

            leftCity = presentCity;

        }

        if (presentCity != null)
            presentCity.next = cur; 
        cur.prev = presentCity;


        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {

                if (cur.next != null) {
                    cur = cur.next;
                }

            }
            else if (order == 2) {

                if (cur.prev != null)
                    cur = cur.prev;

            }
            else if (order == 3) {

                // 오른쪽에 있음 -> 제거
                if (cur.next != null) {

                    City left = cur;
                    City mid = cur.next;
                    City right = cur.next.next;

                    left.next = right;
                    if (right != null)
                        right.prev = left;

                    mid.prev = null; mid.next = null;

                }


            }
            else {

                City newCity = new City(st.nextToken());

                // 오른쪽에 아무 것도 없음
                if (cur.next == null) {

                    cur.next = newCity;
                    newCity.prev = cur;

                }
                // 오른쪽에 뭔가 있음
                else {

                    City left = cur;
                    City mid = newCity;
                    City right = cur.next;


                    mid.prev = left; mid.next = right;
                    left.next = mid; right.prev = mid;


                }
                


            }

            if (cur.prev == null | cur.next == null | cur.prev == cur.next) {
                sb.append("-1 \n");
                continue;
            }

            sb.append(cur.prev.name).append(" ").append(cur.next.name).append("\n");


        }

        System.out.print(sb);



    }


}