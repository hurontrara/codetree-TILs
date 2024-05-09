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

    static int size, startRow, startCol, endRow, endCol;
    static int[][] visited;

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine()); visited = new int[size][size];
        int[] seArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        startRow = seArray[0] - 1; startCol = seArray[1] - 1; endRow = seArray[2] - 1; endCol = seArray[3] - 1;

        // logic
        queue.add(new Point(startRow, startCol, 0));
        visited[startRow][startCol] = 1;
        bfs();

        // 불가능한 경우 출력
        System.out.print(-1);


    }

    static void bfs() {


        while (!queue.isEmpty()) {

            Point point = queue.poll();

            if (point.x == endRow && point.y == endCol) {
                System.out.print(point.distance);
                System.exit(0);
            }

            for (int dir = 0; dir < 8; dir++) {

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
        return row >= 0 && row < size && col >= 0 && col < size && visited[row][col] == 0;
    }




}