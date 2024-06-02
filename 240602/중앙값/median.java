import java.io.*;
import java.util.*;

public class Main {

    static int testCase;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
    static PriorityQueue<Integer> rightQueue = new PriorityQueue<>();


    public static void main(String[] args) throws Exception {

        testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {

            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int mid = Integer.parseInt(st.nextToken());
            sb.append(mid).append(" ");

            for (int i = 1; i < size; i += 2) {

                int firstValue = Integer.parseInt(st.nextToken()); int secondValue = Integer.parseInt(st.nextToken());
                int small = Math.min(firstValue, secondValue); int big = Math.max(firstValue, secondValue);

                // 둘다 작은 경우 -> 일단 둘 다 넣고, 왼쪽 큐에서 하나 꺼내서 mid로 삼고, 기존 mid는 오른쪽 큐에
                if (small <= mid && big <= mid) {
                    leftQueue.add(-1 * small); leftQueue.add(-1 * big);
                    rightQueue.add(mid);
                    mid = leftQueue.poll() * -1;
                }
                // 사이에 있는 경우 -> 왼쪽 큐에 small / 오른쪽 큐에 big
                else if (small <= mid && mid <= big) {
                    leftQueue.add(-1 * small); rightQueue.add(big);
                }

                // 둘다 큰 경우 -> 일단 둘 다 넣고, 오른쪽 큐에서 하나 꺼내서 mid로 삼고, 기존 mid는 왼쪽 큐에
                else {
                    rightQueue.add(small); rightQueue.add(big);
                    leftQueue.add(-1 * mid);
                    mid = rightQueue.poll();
                }

                sb.append(mid).append(" ");

            }

            sb.append("\n");
            leftQueue.clear();
            rightQueue.clear();


        }

        System.out.print(sb);


    }

    




}