import java.io.*;
import java.util.*;

class Point {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {

    static int n, k; // n개의 선분, k 개 이상 겹치는

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Point> pointList = new ArrayList<>();

    static TreeSet<Integer> treeSet = new TreeSet();
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    static TreeMap<Integer, Integer> valueToKey = new TreeMap<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());

        int before = 0;
        int after = 0;
        treeSet.add(before);
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken()); String dir = st.nextToken();

            if (dir.equals("R")) {
                after += size;
            }
            else {
                after -= size;
            }

            treeSet.add(after);
            pointList.add(new Point(Math.min(before, after), Math.max(before, after)));

            before = after;

        }

        int cnt = 0;
        for (int value : treeSet) {
            treeMap.put(value, cnt++);
        }

        for (int key : treeMap.keySet()) {
            valueToKey.put(treeMap.get(key), key);
        }

        int[] axis = new int[treeMap.size()];
        for (Point point : pointList) {

            int a = treeMap.get(point.x);
            int b = treeMap.get(point.y);

            axis[a] += 1; axis[b] -= 1; 

        }


        cnt = 0;
        int answer = 0;
        for (int i = 0; i < axis.length - 1; i++) {

            cnt += axis[i];

            if (cnt >= k)
                answer += Math.abs(valueToKey.get(i) - valueToKey.get(i + 1));

        }

        System.out.print(answer);




    }





}