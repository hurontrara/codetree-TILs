import java.io.*;
import java.util.stream.Stream;
import java.util.*;

class Ball implements Comparable<Ball> {

    int x;
    int y;
    int weight;
    int dir;
    int ballNum;

    Ball(int x, int y, int weight, int dir, int ballNum) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.dir = dir;
        this.ballNum = ballNum;
    
    }

    @Override
    public int compareTo(Ball ball) {
        return this.ballNum - ball.ballNum;
    }


}



public class Main {

    static int size, ballNum, time;
    static int[][] matrix;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Ball> ballList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sbArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        size = sbArray[0]; ballNum = sbArray[1]; time = sbArray[2];
        matrix = new int[size][size];

        for (int i = 0; i < ballNum; i++) {
            String[] ballArray = br.readLine().split(" ");
            int row = Integer.parseInt(ballArray[0]) - 1; int col = Integer.parseInt(ballArray[1]) - 1;
            int dir = ballArray[2].equals("D") ? 0 : ballArray[2].equals("R") ? 1 : ballArray[2].equals("U") ? 2 : 3;
            int weight = Integer.parseInt(ballArray[3]);
            ballList.add(new Ball(row, col, weight, dir, i));
        }

        // 로직
        for (int i = 0; i < time; i++) {
            move();
            breaking();
        }

        // 출력
        System.out.print(ballList.size() + " ");
        int answer = 0;
        for (int i = 0; i < ballList.size(); i++) {
            answer = Math.max(answer, ballList.get(i).weight);
        }
        System.out.print(answer);


    }

    static void breaking() {

        Collections.sort(ballList);

        for (int i = ballList.size() - 1; i >= 0; i--) {

            Ball ball = ballList.get(i);

            if (matrix[ball.x][ball.y] == 0) {
                matrix[ball.x][ball.y] += ball.weight;
            } else {
                matrix[ball.x][ball.y] += ball.weight;
                ballList.remove(i);
            }


        } 

        // matrix 값 따르기
        for (int i = 0; i < ballList.size(); i++) {
            
            Ball ball2 = ballList.get(i);
            ball2.weight = matrix[ball2.x][ball2.y];
        }

        // matrix 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }


    }


    static void move() {

        for (int i = 0; i < ballList.size(); i++) {

            Ball ball = ballList.get(i);
            int currentRow = ball.x + dx[ball.dir];
            int currentCol = ball.y + dy[ball.dir];

            if (!existCheck(currentRow, currentCol)) {
                ball.dir = (ball.dir + 2) % 4;
            } else {
                ball.x = currentRow;
                ball.y = currentCol;
            }

        }


    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }


}