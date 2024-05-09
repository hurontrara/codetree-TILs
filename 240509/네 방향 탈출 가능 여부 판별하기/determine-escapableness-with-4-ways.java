import java.io.*;
import java.util.stream.Stream;
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

    static int n, m;
    static int[][] matrix;
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" ");
        n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);
        matrix = new int[n][m]; visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // logic
        queue.add(new Point(0, 0));
        visited[0][0] = 1;
        bfs();

        // 출력
        System.out.print(0);
        


    }

    static void bfs() {

        while (!queue.isEmpty()) {

            Point point = queue.poll();

            // 끝 지점 도달하면 종료
            if (point.x == n - 1 && point.y == m - 1) {
                System.out.print(1);
                System.exit(0);
            }

            for (int dir = 0; dir < 4; dir++) {
                int currentRow = point.x + dx[dir];
                int currentCol = point.y + dy[dir];

                if (canGo(currentRow, currentCol)) {

                    visited[currentRow][currentCol] = 1;
                    queue.add(new Point(currentRow, currentCol));

                }

            }


        }


    }

    static boolean canGo(int row, int col) {

        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] == 1 && visited[row][col] == 0;

    }


}