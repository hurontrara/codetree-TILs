import java.io.*;
import java.util.stream.Stream;
import java.util.*;

class Ball {

    int x;
    int y;
    int dir;

    Ball(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

}

class Breaking {

    int x;
    int y;

    Breaking(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int testNum, size, ballNum;
    static int[][] matrix;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static List<Ball> ballList = new ArrayList<>();
    static List<Breaking> breakingList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testNum = Integer.parseInt(br.readLine());


        // 로직
        for (int i = 0; i < testNum; i++) {
            String[] sbArray = br.readLine().split(" ");
            size = Integer.parseInt(sbArray[0]); ballNum = Integer.parseInt(sbArray[1]);
            matrix = new int[size][size];

            for (int j = 0; j < ballNum; j++) {
                String[] ballArray = br.readLine().split(" ");
                int row = Integer.parseInt(ballArray[0]) - 1; int col = Integer.parseInt(ballArray[1]) - 1;
                int dir = stringDirToInt(ballArray[2]);
                ballList.add(new Ball(row, col, dir));
            }

            for (int time = 0; time < size * 2; time++) {
                move();
                breakingBall();
            }

        }

        // 출력
        System.out.print(ballList.size());



    }

    static void breakingBall() {

        // matrix에 값 더하기
        for (int i = 0; i < ballList.size(); i++) {

            Ball ball = ballList.get(i);

            matrix[ball.x][ball.y] += 1;

        }

        // matrix 체크해서 2 이상이면 breaking에..
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (matrix[i][j] > 1) {
                    breakingList.add(new Breaking(i, j));
                }

            }
        }

        // breaking 에 있는 것들로 ball 부수기
        for (int i = 0; i < breakingList.size(); i++) {

            Breaking breaking = breakingList.get(i);

            for (int j = ballList.size() - 1; j >= 0; j--) {

                Ball localBall = ballList.get(j);

                if (localBall.x == breaking.x && localBall.y == breaking.y) {
                    ballList.remove(j);
                }

            }

        }


        // 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }

        breakingList.clear();


    }

    static void move() {

        for (int i = 0; i < ballList.size(); i++) {

            Ball ball = ballList.get(i);

            int futureRow = ball.x + dx[ball.dir];
            int futureCol = ball.y + dy[ball.dir];

            if (existCheck(futureRow, futureCol)) { 
                ball.x = futureRow;
                ball.y = futureCol;
            } else {
                ball.dir = (ball.dir + 2) % 4;
            }


        }

    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }




    static int stringDirToInt(String stringDir) {
        return stringDir.equals("D") ? 0 : stringDir.equals("R") ? 1 : stringDir.equals("U") ? 2 : 3;
    }


}

// 이동
// 체크(행렬)
// 삭제