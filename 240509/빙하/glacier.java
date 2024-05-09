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
    static int time = 0;

    static int save = 0;
    
    static Queue<Point> queue = new LinkedList<>();
    static List<Point> meltingList = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" ");
        n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);
        matrix = new int[n][m]; visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = array;

            for (int value : array) {
                save += value;
            }
        }
        
        // logic 
        while (true) {
            
            time++;
            queue.add(new Point(0, 0));
            visited[0][0] = 1;
            
            bfs();

            // visited 초기화 하면서 갯수 세기 : save
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] == 1) {
                        visited[i][j] = 0;
                        matrix[i][j] = 0;
                    }
                    if (matrix[i][j] == 0)
                        count++;
                }
            }

            if (count == n * m) {
                System.out.print(time + " " + save);
                System.exit(0);
            }

            save = n * m - count;

        }

    }

    static void bfs() {

        while (!queue.isEmpty()) {

            Point point = queue.poll();

            // 녹아야 하는 것이 있다면 추가
            for (int dir = 0; dir < 4; dir++) {

                int currentRow = point.x + dx[dir];
                int currentCol = point.y + dy[dir];

                if (canGo(currentRow, currentCol)) {
                    queue.add(new Point(currentRow, currentCol));
                    visited[currentRow][currentCol] = 1;
                } else if (canMelt(currentRow, currentCol)) {
                    visited[currentRow][currentCol] = 1;
                }

            }

        } 



    }

    static boolean canGo(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] == 0 && visited[row][col] == 0;
    }

    static boolean canMelt(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] == 1 && visited[row][col] == 0;
    }

    







}