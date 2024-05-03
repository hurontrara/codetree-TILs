import java.io.*;
import java.util.stream.Stream;

public class Main {

    static int size, ballCount, time;
    static int[][] matrix;
    static int[][] ballMatrix;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws Exception {
        // 초기화

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sbArray = br.readLine().split(" ");
        size = Integer.parseInt(sbArray[0]); ballCount = Integer.parseInt(sbArray[1]); time = Integer.parseInt(sbArray[2]);
        matrix = new int[size][size];
        ballMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < ballCount; i++) {
            String[] rcArray = br.readLine().split(" ");
            int row = Integer.parseInt(rcArray[0]) - 1;
            int col = Integer.parseInt(rcArray[1]) - 1;
            ballMatrix[row][col] = 1;
        }
        answer = ballCount;

        // 로직
        // 1. 움직이기
        // 2. 깨뜨리기
        for (int i = 0; i < time; i++) {
            move();
            breaking();

        }

        // 출력
        System.out.print(answer);


    }

    static void breaking() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (ballMatrix[i][j] > 1) {

                    ballCount -= ballMatrix[i][j];
                    ballMatrix[i][j] = 0;

                }

            }
        }

    }

    static void move() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (ballMatrix[i][j] == 1) {

                    for (int dir = 0; dir < 4; dir++) {

                        int futureRow = i + dx[dir];
                        int futureCol = j + dy[dir];

                        if (existCheck(futureRow, futureCol) && matrix[i][j] < matrix[futureRow][futureCol]) {

                            ballMatrix[futureRow][futureCol] += 1;
                            ballMatrix[i][j] = 0;
                        }
                        

                    } 


                }

            }
        }


    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}

// 상하좌우 순서