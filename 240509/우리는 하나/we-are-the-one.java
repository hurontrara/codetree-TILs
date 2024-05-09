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

    static int size, k, u, d;
    static int[][] matrix;
    static int[][] visited;

    static int answer = 0;

    static List<Point> pointList = new ArrayList<>();

    static List<Point> tmpList = new ArrayList<>();

    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] skArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        size = skArray[0]; k = skArray[1]; u = skArray[2]; d = skArray[3];
        matrix = new int[size][size]; visited = new int[size][size];

        for (int i = 0; i < size; i++) {

            int[] pointArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = pointArray;
            for (int j = 0; j < size; j++) {

                pointList.add(new Point(i, j));

            }

        }

        // logic
        // size * size 개의 도시 중 K개를 선택
        // 선택 후 각 도시에 대하여 BFS

        for (int i = 0; i < size * size; i++) {
            recursive(i, 0);
        }

        // print
        System.out.print(answer);

    }

    static void recursive(int index, int count) {

        // 로직
        // tmpList에 시작 도시 위치들이 들어있는 상태
        if (index == size * size && count == k) {

            for (int i = 0; i < k; i++) {
                Point point = tmpList.get(i);
                queue.add(point);
                visited[point.x][point.y] = 1;
            }

            bfs();


 
        }

        // 필요없는 것 쳐내기
        if (index == size * size || count == k) {
            return;
        }

        tmpList.add(pointList.get(index));
        for (int i = index; i < size * size; i++) {
            recursive(i + 1, count + 1);
        }
        tmpList.remove(tmpList.size() - 1);



    }

    static void bfs() {

        while (!queue.isEmpty()) {

            Point point = queue.poll();
            int value = matrix[point.x][point.y];

            for (int dir = 0; dir < 4; dir++) {

                int futureRow = point.x + dx[dir];
                int futureCol = point.y + dy[dir];

                if (canGo(futureRow, futureCol, value)) {
                    queue.add(new Point(futureRow, futureCol));
                    visited[futureRow][futureCol] = 1;
                }


            }



        }


        // 초기화 및 계산
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cnt += visited[i][j];
                visited[i][j] = 0;
            }
        }
        answer = Math.max(cnt, answer);



    }

    static boolean canGo(int row, int col, int value) {

        return row >= 0 && row < size && col >= 0 && col < size && Math.abs(value - matrix[row][col]) >= u && Math.abs(value - matrix[row][col]) <= d && visited[row][col] == 0;
    }




}