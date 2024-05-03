import java.io.*;
import java.util.stream.Stream;
import java.util.*;


class Bomb {

    int x;
    int y;

    Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }


}

public class Main {

    static int size, time, startRow, startCol;
    static int[][] matrix;
    static List<Bomb> list = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        // 초기화

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stArray = br.readLine().split(" ");
        size = Integer.parseInt(stArray[0]); time = Integer.parseInt(stArray[1]);
        startRow = Integer.parseInt(stArray[2]) - 1; startCol = Integer.parseInt(stArray[3]) - 1;
        matrix = new int[size][size];

        matrix[startRow][startCol] = 1;
        list.add(new Bomb(startRow, startCol));

        // 로직
        for (int i = 1; i <= time; i++) {
            bombProcess(i);
        }

        // 출력
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                answer += matrix[i][j];
            }
        }
        System.out.print(answer);

    }

    static void bombProcess(int time) {

        int listSize = list.size();

        for (int i = 0; i < listSize; i++) {

            Bomb bomb = list.get(i);

            for (int dir = 0; dir < 4; dir++) {

                int currentRow = bomb.x + (int) Math.pow(2, time - 1) * dx[dir];
                int currentCol = bomb.y + (int) Math.pow(2, time - 1) * dy[dir];

                if (existCheck(currentRow, currentCol) && matrix[currentRow][currentCol] == 0) {
                    matrix[currentRow][currentCol] = 1;
                    list.add(new Bomb(currentRow, currentCol));
                }


            }

        }


    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }


}