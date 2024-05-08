import java.io.*;
import java.util.stream.Stream;
import java.util.*;


public class Main {

    static int size;
    static int[][] matrix;
    static int[][] visited;
    static List<Integer> countList = new ArrayList<>();
    static int count = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        matrix = new int[size][size];
        visited = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        // 로직
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                // 방문한 적 없으면
                if (visited[i][j] == 0 && matrix[i][j] == 1) {

                    visited[i][j] = 1;
                    dfs(i, j, 1);

                    countList.add(count);

                    count = 0;


                }



            }

        }


        // 출력 
        Collections.sort(countList);
        System.out.println(countList.size());
        for (int value : countList) {
            System.out.println(value);
        }

    }

    static void dfs(int row, int col, int localCount) {

        // count 갱신
        count = Math.max(count, localCount);

        // dfs
        for (int dir = 0; dir < 4; dir++) {

            int currentRow = row + dx[dir];
            int currentCol = col + dy[dir];

            if (canGo(currentRow, currentCol)) {

                visited[currentRow][currentCol] = 1;
                dfs(currentRow, currentCol, localCount + 1);

            }

        }




    }

    // 격자 내에 존재 + 0 아님
    static boolean canGo(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] == 1 && visited[row][col] == 0;
    }





}