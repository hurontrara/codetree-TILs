import java.io.*;
import java.util.stream.Stream;
import java.util.*;


public class Main {

    static int n, m;
    static int[][] matrix;
    static int[][] tmpMatrix;

    static int globalCount = 0;
    static int globalK = Integer.MAX_VALUE;

    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static Set<Integer> kSet = new HashSet<>();

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" ");
        n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);
        matrix = new int[n][m];
        tmpMatrix = new int[n][m];
        visited = new int[n][m];

        // matrix 초기화 + 가능한 k 값 라벨링
        for (int i = 0; i < n; i++) {
            int[] rowArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = rowArray;

            for (int j = 0; j < m; j++) {

                int value = matrix[i][j];
                kSet.add(value);

            }
        }
        kSet.add(1);

        // 로직
        // k에 대하여 tmpMatrix 초기화
        // bfs 돌리기(localCount(안전영역의 수) 세기)
        // localCount가 count보다 큰 경우 
        // localCount가 count와 같고, k가 작은 경우
        // K를 현재 k로 바꾸고, count = localCount;

        for (int localK : kSet) {

            // tmpMatrix 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (localK >= matrix[i][j]) {
                        tmpMatrix[i][j] = 0; 
                    } else {
                        tmpMatrix[i][j] = 1;
                    }

                }
            }

            // dfs
            int localCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (tmpMatrix[i][j] == 1 && visited[i][j] == 0) {
                        visited[i][j] = 1;
                        dfs(i, j);
                        localCount++;
                    }

                }
            }

            // localCount가 count보다 큰 경우 
            // localCount가 count와 같고, k가 작은 경우
            if (localCount > globalCount) {
                globalK = localK;
                globalCount = localCount;
            }

            if (localCount == globalCount && localK < globalK) {
                globalK = localK;
            }



            // localCount, visited 초기화
            localCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = 0;
                }
            }




        }

        // 출력
        System.out.print(globalK + " " + globalCount);







    }

    static void dfs(int row, int col) {

        for (int dir = 0; dir < 4; dir++) {

            int currentRow = row + dx[dir];
            int currentCol = col + dy[dir];

            if (canGo(currentRow, currentCol)) {

                visited[currentRow][currentCol] = 1;
                dfs(currentRow, currentCol);

            }
        }


    }

    static boolean canGo(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m && tmpMatrix[row][col] == 1 && visited[row][col] == 0; 
    }




}