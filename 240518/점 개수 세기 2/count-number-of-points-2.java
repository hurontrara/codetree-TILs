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

    static int n, q; // n개의 점, q개의 쿼리

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Integer> xTreeSet = new TreeSet<>();
    static TreeSet<Integer> yTreeSet = new TreeSet<>();

    static List<Point> pointList = new ArrayList<>();

    static TreeMap<Integer, Integer> colTreeMap = new TreeMap<>();
    static TreeMap<Integer, Integer> rowTreeMap = new TreeMap<>(); 

    static int[][] matrix;
    static int[][] sumMatrix;

    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());
        matrix = new int[n + 1][n + 1];
        sumMatrix = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
            xTreeSet.add(x); yTreeSet.add(y);

            pointList.add(new Point(x, y));

        }

        int cnt = 1;
        for (int x : xTreeSet) {
            colTreeMap.put(x, cnt);
            cnt++;
        }

        cnt = n;
        for (int y : yTreeSet) {
            rowTreeMap.put(y, cnt);
            cnt--;
        }

        for (Point point : pointList) {
            matrix[rowTreeMap.get(point.y)][colTreeMap.get(point.x)] = 1;
        }

        // 누적합 만들기
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j];
            }
        }


        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int x1ToCol = colTreeMap.get(xTreeSet.ceiling(x1));
            int y1ToRow = rowTreeMap.get(yTreeSet.ceiling(y1));
            int x2ToCol = colTreeMap.get(xTreeSet.floor(x2));
            int y2ToRow = rowTreeMap.get(yTreeSet.floor(y2));

            int firstRow = y2ToRow; int firstCol = x1ToCol;
            int secondRow = y1ToRow; int secondCol = x2ToCol;

            int answer = sumMatrix[secondRow][secondCol] - sumMatrix[firstRow - 1][secondCol] - sumMatrix[secondRow][firstCol - 1] + sumMatrix[firstRow - 1][firstCol - 1];
            sb.append(answer).append("\n");

        }
        System.out.print(sb);







    }



}