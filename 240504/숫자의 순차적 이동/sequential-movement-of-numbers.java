import java.io.*;
import java.util.stream.Stream;

class Number {

    int x;
    int y;

    Number(int x, int y) {

        this.x = x;
        this.y = y;
    }


}

public class Main {

    static int size, turn;
    static int[][] matrix;
    static Number[] numberArray;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stArray = br.readLine().split(" ");
        size = Integer.parseInt(stArray[0]); turn = Integer.parseInt(stArray[1]);
        matrix = new int[size][size];
        numberArray = new Number[size * size + 1]; // 그대로 저장
        for (int i = 0; i < size; i++) {
            int[] localRow = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = localRow;
            for (int j = 0; j < size; j++) {
                int value = localRow[j];
                numberArray[value] = new Number(i, j);
            }


        }

        // 로직
        for (int t = 0; t < turn; t++) {

            for (int idx = 1; idx <= size * size; idx++) {

                change(idx);

            }

        }


        // 출력
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        


    }

    static void change(int idx) {

        Number number = numberArray[idx];
        int row = number.x;
        int col = number.y;

        int value = -1;
        int localDir = -1;

        for (int dir = 0; dir < 8; dir++) {

            if (existCheck(row + dx[dir], col + dy[dir]) && value < matrix[row + dx[dir]][col + dy[dir]]) {
                value = matrix[row + dx[dir]][col + dy[dir]];
                localDir = dir;
            }


        }

        int futureRow = row + dx[localDir];
        int futureCol = col + dy[localDir];
        Number futureNumber = numberArray[value];

        // 변경
        matrix[row][col] = matrix[futureRow][futureCol];
        matrix[futureRow][futureCol] = idx;
        number.x = futureRow; number.y = futureCol;
        futureNumber.x = row; futureNumber.y = col;


    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }


}