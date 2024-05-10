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

    static int size, h, m;
    static int[][] matrix;
    static int[][] visited;

    static List<Point> humanPointList = new ArrayList<>();

    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] savedMatrix;

    static int count;


    public static void main(String[] args) throws Exception {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] shArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        size = shArray[0]; h = shArray[1]; m = shArray[2]; matrix = new int[size][size]; visited = new int[size][size]; savedMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 사람 목록 작성
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {


                if (matrix[i][j] == 2) {
                    humanPointList.add(new Point(i, j, 0));
                }

            }
        }

        // logic
        // 각 사람에 대하여 BFS
        for (Point point : humanPointList) {

            count = -1;

            queue.add(point);
            visited[point.x][point.y] = 1;
            bfs();

            // 거리 저장
            savedMatrix[point.x][point.y] = count;

            // visited 초기화
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    visited[i][j] = 0;
                }
            }

        }


        // print
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(savedMatrix[i][j] + " ");
            }
            System.out.println();
        }



    }

    static void bfs() {
        
        while (!queue.isEmpty()) {

            Point point = queue.poll();

            // 종료 조건
            if (matrix[point.x][point.y] == 3) {
                count = point.distance;
                queue.clear();
                return;
            }

            for (int dir = 0; dir < 4; dir++) {

                int futureRow = point.x + dx[dir];
                int futureCol = point.y + dy[dir];

                if (canGo(futureRow, futureCol)) {

                    visited[futureRow][futureCol] = 1;
                    queue.add(new Point(futureRow, futureCol, point.distance + 1));

                }

            }

        }

    }

    static boolean canGo(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] != 1 && visited[row][col] == 0;
    }



}