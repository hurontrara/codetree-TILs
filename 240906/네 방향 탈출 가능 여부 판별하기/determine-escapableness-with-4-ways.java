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

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[][] matrix;
    static int[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m]; visited = new int[n][m];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {

                matrix[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        queue.add(new Point(0, 0));
        visited[0][0] = 1;

        bfs();

        System.out.println(0);



    }

    static void bfs() {

        while (!queue.isEmpty()) {

            Point point = queue.poll();

            if (point.x == n - 1 && point.y == m - 1) {
                System.out.print(1);
                System.exit(0);
            }

            for (int dir = 0; dir < 4; dir++) {

                int futureX = point.x + dx[dir];
                int futureY = point.y + dy[dir];

                if (existCheckAndNotVisit(futureX, futureY)) {

                    queue.add(new Point(futureX, futureY));
                    visited[futureX][futureY] = 1;


                }


            }


        }


    }
    
    static boolean existCheckAndNotVisit(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && visited[x][y] == 0;
    }


}