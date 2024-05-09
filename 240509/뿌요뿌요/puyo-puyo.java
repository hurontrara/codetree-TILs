import java.io.*;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static int size;
    static int[][] matrix;
    static int[][] visited;

    static int maxBlock = 0;
    static int localBlock = 0;
    static int count = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size]; visited = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // logic
        // 몇 번 터지는지 계산 + 최대 블럭 수 계산
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (visited[i][j] == 0) {

                    visited[i][j] = 1;
                    dfs(i, j, matrix[i][j]);


                    // localBlock 값 계산해서 maxBlock과 비교

                    if (localBlock >= 4) {
                        count++;
                    }

                    maxBlock = Math.max(localBlock, maxBlock);

                    localBlock = 0;


                }


            }
        }

        // 출력
        System.out.print(count + " " + maxBlock);



    }

    static void dfs(int row, int col, int value) {

        localBlock++;

        for (int dir = 0; dir < 4; dir++) {

            int currentRow = row + dx[dir];
            int currentCol = col + dy[dir];

            if (canGo(currentRow, currentCol, value)) {
                visited[currentRow][currentCol] = 1;
                dfs(currentRow, currentCol, value);
            }

        }

    }

    static boolean canGo(int row, int col, int value) {
        return row >= 0 && row < size && col >= 0 && col < size && value == matrix[row][col] && visited[row][col] == 0;
    }


}