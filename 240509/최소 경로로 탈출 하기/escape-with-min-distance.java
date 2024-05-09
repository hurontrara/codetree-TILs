import java.io.*;
import java.util.stream.Stream;
import java.util.*;

class Point {

    int x;
    int y;
    int distance;

    Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

}


public class Main {

    static int n, m;
    static int[][] matrix;
    static int[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nmArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nmArray[0]; m = nmArray[1]; matrix = new int[n][m]; visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // logic
        // 출발점 넣고 BFS
        queue.add(new Point(0, 0, 0));
        visited[0][0] = 1;
        bfs();

        // 종료시점 안나온 경우 출력
        System.out.print(-1);


    }

    static void bfs() {

        // 큐 확인해서 종료 시점이면 거리 출력하고 종료

        while (!queue.isEmpty()) {

            Point point = queue.poll();

            if (point.x == n - 1 && point.y == m - 1) {
                System.out.print(point.distance);
                System.exit(0);
            }

            for (int dir = 0; dir < 4; dir++) {

                int futureRow = point.x + dx[dir];
                int futureCol = point.y + dy[dir];


                if (canGo(futureRow, futureCol)) {

                    queue.add(new Point(futureRow, futureCol, point.distance + 1));
                    visited[futureRow][futureCol] = 1;

                }

            }



        }



    }

    static boolean canGo(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] == 1 && visited[row][col] == 0;
    }



}