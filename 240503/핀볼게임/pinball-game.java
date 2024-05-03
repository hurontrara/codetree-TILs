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


public class Main {

    static int size;
    static int[][] matrix;
    static int answer = -1;
    static Queue<Ball> queue = new LinkedList<>();

    static int[] dx = {0, 1, 0, -1}; // <- 0
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 로직
        insertQueue();
        moveBall();

        // 출력
        System.out.print(answer);

    }

    static void moveBall() {

        while (!queue.isEmpty()) {

            int time = 1;
            Ball ball = queue.poll();

            while (true) {

                // 방향 바꾸고

                int value = matrix[ball.x][ball.y];

                if (value == 1)
                    ball.dir ^= 1;

                if (value == 2)
                    ball.dir ^= 3;

                // 움직이기(밖이라면 시간 체크)
                
                if (!existCheck(ball.x + dx[ball.dir], ball.y + dy[ball.dir])) {
                    answer = Math.max(answer, time + 1);
                    break;
                }

                ball.x += dx[ball.dir];
                ball.y += dy[ball.dir];
                time++;

            }




        }



    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }



    static void insertQueue() {

        for (int dir = 0; dir < 4; dir++) {
            for (int i = 0; i < size; i++) {

                switch (dir) {
                    
                    case (0):
                        queue.add(new Ball(i, size - 1, dir));
                        break;
                    
                    case (1):
                        queue.add(new Ball(0, i, dir));
                        break;
                    
                    case (2):
                        queue.add(new Ball(i, 0, dir));
                        break;

                    case (3):
                        queue.add(new Ball(size - 1, i, dir));
                        break;

                }

            }
        }

    }

}


// 1번은 / 2번은 \