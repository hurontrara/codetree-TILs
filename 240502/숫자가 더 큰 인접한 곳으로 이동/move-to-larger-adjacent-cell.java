import java.io.*;
import java.util.stream.Stream;
import java.util.*;


public class Main {

    static int size, startRow, startCol;
    static int[][] matrix;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sssArray = br.readLine().split(" ");
        size = Integer.parseInt(sssArray[0]); startRow = Integer.parseInt(sssArray[1]) - 1; startCol = Integer.parseInt(sssArray[2]) - 1;
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 로직
        move();

        // 출력
        while (!queue.isEmpty())
            System.out.print(queue.poll() + " ");


    }

    static void move() {

        queue.add(matrix[startRow][startCol]);
        int currentRow = startRow;
        int currentCol = startCol;

        while (true) {

            int recentValue = matrix[currentRow][currentCol];
            boolean movement = false;
            for (int dir = 0; dir < 4; dir++) {

                if (existCheck(currentRow + dx[dir], currentCol + dy[dir]) && matrix[currentRow + dx[dir]][currentCol + dy[dir]] > recentValue) {
                    currentRow += dx[dir];
                    currentCol += dy[dir];
                    queue.add(matrix[currentRow][currentCol]);
                    movement = true;
                    break;
                }

            }

            if (!movement)
                break;

        }


    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }



}