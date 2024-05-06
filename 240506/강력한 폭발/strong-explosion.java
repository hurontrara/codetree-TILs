import java.io.*;
import java.util.stream.Stream;
import java.util.*;

class Position {

    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {

    static int size;
    static int[][] matrix;
    static int[][] boomedMatrix;
    static List<Integer> numList = new ArrayList<>();
    static List<Position> positionList = new ArrayList<>();
    static int answer = 0;

    static int[] oneDx = {-2, -1, 0, 1, 2};
    static int[] oneDy = {0, 0, 0, 0, 0};

    static int[] twoDx = {0, 0, 0, -1, 1};
    static int[] twoDy = {-1, 1, 0, 0, 0};

    static int[] threeDx = {-1, -1, 0, 1, 1};
    static int[] threeDy = {-1, 1, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size];
        boomedMatrix = new int[size][size];


        for (int i = 0; i < size; i++) {

            int[] numArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numArray;
            for (int j = 0; j < size; j++) {
                if (numArray[j] == 1) {
                    positionList.add(new Position(i, j));
                }
            }

        }

        // 로직
        recursive(0);

        // 출력
        System.out.print(answer);




    }

    static void recursive(int index) {

        if (index == positionList.size()) {

            int cnt = 0;
            for (int i = 0; i < positionList.size(); i++) {

                int num = numList.get(i);
                Position position = positionList.get(i);

                int[] dx;
                int[] dy;

                if (num == 1) {
                    dx = oneDx; dy = oneDy;
                } else if (num == 2) {
                    dx = twoDx; dy = twoDy;
                } else {
                    dx = threeDx; dy = threeDy;
                }

                for (int dir = 0; dir < 5; dir++) {
                    int currentRow = position.x + dx[dir];
                    int currentCol = position.y + dy[dir];

                    if (existCheck(currentRow, currentCol) && boomedMatrix[currentRow][currentCol] != 1) {
                        boomedMatrix[currentRow][currentCol] = 1;
                        cnt++;
                    }
                }



            }

            // 초기화
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    boomedMatrix[i][j] = 0;
                }
            }

            answer = Math.max(cnt, answer);



            return;
        }

        for (int i = 1; i <= 3; i++) {
            numList.add(i);
            recursive(index + 1);
            numList.remove(numList.size() - 1);
        }


    } 

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }



}