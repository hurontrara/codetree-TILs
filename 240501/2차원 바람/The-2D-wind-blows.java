import java.io.*;
import java.util.*;
import java.util.stream.Stream;


public class Main {

    static int n, m, time;
    static int[][] matrix;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmtArray = br.readLine().split(" ");
        n = Integer.parseInt(nmtArray[0]); m = Integer.parseInt(nmtArray[1]); time = Integer.parseInt(nmtArray[2]);
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 로직
        for (int i = 0; i < time; i++) {
            String[] boxArray = br.readLine().split(" ");
            int firstRow = Integer.parseInt(boxArray[0]) - 1; int firstCol = Integer.parseInt(boxArray[1]) - 1;
            int secondRow = Integer.parseInt(boxArray[2]) - 1; int secondCol = Integer.parseInt(boxArray[3]) - 1;

            rotate(firstRow, firstCol, secondRow, secondCol);

            meaning(firstRow, firstCol, secondRow, secondCol);
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }



    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    static void meaning(int firstRow, int firstCol, int secondRow, int secondCol) {

        int localValue = 0;
        int cnt = 0;
        for (int i = firstRow; i <= secondRow; i++) {
            for (int j = firstCol; j <= secondCol; j++) {

                for (int k = 0; k < 4; k++) {
                    if (existCheck(i + dx[k], j + dy[k])) {
                        localValue += matrix[i + dx[k]][j + dy[k]];
                        cnt++;
                    }
                }
                localValue += matrix[i][j];

                queue.add(localValue / (cnt + 1));
                localValue = 0;
                cnt = 0;


            }
        }

        for (int i = firstRow; i <= secondRow; i++) {
            for (int j = firstCol; j <= secondCol; j++) {

                matrix[i][j] = queue.poll();

            }
        }



    }

    static void rotate(int firstRow, int firstCol, int secondRow, int secondCol) {

        // 삽입
        for (int i = firstCol; i <= secondCol; i++) {
            queue.add(matrix[firstRow][i]);
        }

        for (int i = firstRow + 1; i <= secondRow - 1; i++) {
            queue.add(matrix[i][secondCol]);
        }

        for (int i = secondCol; i >= firstCol; i--) {
            queue.add(matrix[secondRow][i]);
        }

        for (int i = secondRow - 1; i >= firstRow + 1; i--) {
            queue.add(matrix[i][firstCol]);
        }

        // poll
        for (int i = firstCol + 1; i <= secondCol; i++) {
            matrix[firstRow][i] = queue.poll();
        }

        for (int i = firstRow + 1; i <= secondRow - 1; i++) {
            matrix[i][secondCol] = queue.poll();
        }

        for (int i = secondCol; i >= firstCol; i--) {
            matrix[secondRow][i] = queue.poll();
        }

        for (int i = secondRow - 1; i >= firstRow; i--) {
            matrix[i][firstCol] = queue.poll();
        }

        assert queue.isEmpty();



    }



}