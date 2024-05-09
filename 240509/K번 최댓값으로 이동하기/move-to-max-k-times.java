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

    static int size, time;
    static int[][] matrix;
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int currentRow = 0;
    static int currentCol = 0;

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stArray = br.readLine().split(" ");
        size = Integer.parseInt(stArray[0]); time = Integer.parseInt(stArray[1]);
        matrix = new int[size][size]; visited = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        String[] ccArray = br.readLine().split(" ");
        currentRow = Integer.parseInt(ccArray[0]) - 1; currentCol = Integer.parseInt(ccArray[1]) - 1;

        for (int t = 0; t < time; t++) {

            // 돌면서 currentRow, currentCol 세팅
            int savedRow = currentRow; int savedCol = currentCol;
            queue.add(new Point(currentRow, currentCol));
            visited[currentRow][currentCol] = 1;
            bfs();

            // 변화없으면 종료
            if (savedRow == currentRow && savedCol == currentCol) {
                System.out.print((currentRow + 1) + " " + (currentCol + 1));
                System.exit(0);
            } 

            // visited 초기화
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    visited[i][j] = 0;
                }
            }


        }

        // 다 돌았으면 출력
        System.out.print((currentRow + 1) + " " + (currentCol + 1));





    }


    static void bfs() {

        int value = matrix[currentRow][currentCol];
        int localValue = 0;

        while (!queue.isEmpty()) {

            Point point = queue.poll();


            for (int dir = 0; dir < 4; dir++) {

                int futureRow = point.x + dx[dir];
                int futureCol = point.y + dy[dir];

                if (canGo(futureRow, futureCol, value)) {

                    visited[futureRow][futureCol] = 1;
                    queue.add(new Point(futureRow, futureCol));

                }
            }


            if (currentRow == point.x && currentCol == point.y)
                continue;

            // localValue 보다 크면 갱신
            // localValue 랑 같고, 행이 작으면 갱신
            // localValue 랑 같고, 행이 같고, 열이 작으면 갱신
            if ((matrix[point.x][point.y] > localValue) || (matrix[point.x][point.y] == localValue && currentRow > point.x) ||
                (matrix[point.x][point.y] == localValue && point.x == currentRow && point.y < currentCol)) {

                currentRow = point.x;
                currentCol = point.y;
                localValue = matrix[currentRow][currentCol];

            } 





        }

    }

    static boolean canGo(int row, int col, int value) {
        return row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] < value && visited[row][col] == 0;
    }


}