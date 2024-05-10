import java.io.*;
import java.util.stream.Stream;
import java.util.*;


class Point {

    int x;
    int y;
    int time;

    Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

}

public class Main {

    static int size, k;
    static int[][] matrix;
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<Point> queue = new LinkedList<>();
    

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] skArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        size = skArray[0]; k = skArray[1]; matrix = new int[size][size]; visited = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // logic
        // visited 모두 -1로 시작 + 상한 귤 큐에 넣기

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (matrix[i][j] == 0) {
                    visited[i][j] = -1;
                } else if (matrix[i][j] == 1) {
                    visited[i][j] = -2;
                } else {
                    queue.add(new Point(i, j, 0));
                    visited[i][j] = 0;
                }
            }
        }

        bfs();


        // print

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        
    }


    static void bfs() {

        while (!queue.isEmpty()) {

            Point point = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int futureRow = point.x + dx[dir];
                int futureCol = point.y + dy[dir];

                if (canGo(futureRow, futureCol)) {
                    queue.add(new Point(futureRow, futureCol, point.time + 1));
                    visited[futureRow][futureCol] = point.time + 1;
                }


            }


        }



    }

    static boolean canGo(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && visited[row][col] == -2;
    }






}