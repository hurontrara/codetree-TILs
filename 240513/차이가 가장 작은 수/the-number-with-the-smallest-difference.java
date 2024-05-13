import java.io.*;
import java.util.*;


public class Main {

    static int n, m; // n개의 정수, 차이가 m 이상

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static TreeSet<Integer> treeSet = new TreeSet<>();

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {

            treeSet.add(Integer.parseInt(br.readLine()));

        }

        // 반복문 돌면서 m 이상이면서 제일 작은 경우 찾기
        for (int value : treeSet) {

            Integer findValue = treeSet.ceiling(value + m);

            answer = Math.min(answer, findValue == null ? Integer.MAX_VALUE : findValue - value);

        }

        System.out.print(answer);


    }



}