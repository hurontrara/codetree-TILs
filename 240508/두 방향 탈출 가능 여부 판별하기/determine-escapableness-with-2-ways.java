import java.io.*;
import java.util.*;
import java.util.stream.Stream;


public class Main {

    static int n, m;
    static int[][] matrix;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static int[][] visited;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" ");
        n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);

        matrix = new int[n][m]; visited = new int[n][m];
        visited[0][0] = 1;

        // 로직
        dfs(0, 0);

        // 출력
        System.out.print(0);

    }

    static void dfs(int row, int col) {

        if (row == n - 1 && col == m - 1) {
            System.out.print(1);
            System.exit(0);
        }

        for (int dir = 0; dir < 2; dir++) {

            int currentRow = row + dx[dir];
            int currentCol = col + dy[dir];

            if (canGo(currentRow, currentCol)) {
                visited[currentRow][currentCol] = 1;
                dfs(currentRow, currentCol);
            }

        }


    }

    // 격자 내에 존재, 뱀 아님, 방문한 적 없음
    static boolean canGo(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] == 1 && visited[row][col] == 0;
    }




}