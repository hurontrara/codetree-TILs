import java.io.*;
import java.util.stream.Stream;
import java.util.*;


// matrix를 maxBallCount로 깔아놓고 속도순으로 정렬한다음 거꾸로 하나씩 지우기 -> 이미 0이라면 볼을 삭제

class Ball implements Comparable<Ball> {

    int x;
    int y;
    int dir;
    int speed;
    int ballNum;

    Ball(int x, int y, int dir, int speed, int ballNum) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.speed = speed;
        this.ballNum = ballNum;
    }

    @Override
    public int compareTo(Ball ball) {

        if (this.speed == ball.speed)
            return this.ballNum - ball.ballNum;

        return this.speed - ball.speed;
    }


}


public class Main {

    static int size, ballNum, time, maxBallCount;
    static int[][] matrix;
    static List<Ball> ballList = new ArrayList<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sbArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        size = sbArray[0]; ballNum = sbArray[1]; time = sbArray[2]; maxBallCount = sbArray[3];
        matrix = new int[size][size];
        
        for (int i = 0; i < ballNum; i++) {
            String[] ballArray = br.readLine().split(" ");
            int row = Integer.parseInt(ballArray[0]) - 1; int col = Integer.parseInt(ballArray[1]) - 1;
            int dir = ballArray[2].equals("D") ? 0 : ballArray[2].equals("R") ? 1 : ballArray[2].equals("U") ? 2 : 3;
            int speed = Integer.parseInt(ballArray[3]);

            ballList.add(new Ball(row, col, dir, speed, i));
        }

        // 로직
        for (int i = 0; i < time; i++) {
            move();
            breaking();
        }

        System.out.print(ballList.size());

        
    }

    static void breaking() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = maxBallCount;
            }
        }

        Collections.sort(ballList);

        for (int i = ballList.size() - 1; i >= 0; i--) {
            Ball ball = ballList.get(i);

            if (matrix[ball.x][ball.y] == 0) {
                ballList.remove(i);
                continue;
            }

            matrix[ball.x][ball.y] -= 1;
        }


    }



    static void move() {

        for (int i = 0; i < ballList.size(); i++) {

            Ball ball = ballList.get(i);

            for (int t = 0; t < ball.speed; t++) {


                if (!existCheck(ball.x + dx[ball.dir], ball.y + dy[ball.dir])) {
                    ball.dir = (ball.dir + 2) % 4;
                } 

                ball.x += dx[ball.dir];
                ball.y += dy[ball.dir];

            }


        }


    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }


}