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

    static int size, startNum;
    static int[][] matrix;
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Queue<Point> queue = new LinkedList<>();


    public static void main(String[] args) throws Exception {
        // init

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ssArray = br.readLine().split(" ");
        size = Integer.parseInt(ssArray[0]); startNum = Integer.parseInt(ssArray[1]);
        matrix = new int[size][size]; visited = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // logic
        // 주어지는 시작점 N개에 대하여 BFS
        for (int i = 0; i < startNum; i++) {

            String[] pointArray = br.readLine().split(" ");
            int row = Integer.parseInt(pointArray[0]) - 1; int col = Integer.parseInt(pointArray[1]) - 1;

            visited[row][col] = 1;
            queue.add(new Point(row, col));
            bfs();

        }

        // print
        int answer = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visited[i][j] == 1)
                    answer++;
            }
        }
        System.out.print(answer);




    }


    static void bfs() {

        while (!queue.isEmpty()) {

            Point point = queue.poll();

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
        return row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] == 0 && visited[row][col] == 0;
    }



}