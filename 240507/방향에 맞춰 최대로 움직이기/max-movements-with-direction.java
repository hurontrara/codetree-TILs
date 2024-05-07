import java.io.*;
import java.util.stream.Stream;
import java.util.*;

class State {

    int x;
    int y;
    int count;

    State(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

}

public class Main {

    static int size;
    static int[][] matrix;
    static int[][] dirMatrix;

    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    static Queue<State> stateQueue = new LinkedList<>();

    static int answer = 0;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size];
        dirMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < size; i++) {
            dirMatrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        String[] startPoint = br.readLine().split(" ");
        stateQueue.add(new State(Integer.parseInt(startPoint[0]) - 1, Integer.parseInt(startPoint[1]) - 1, 0));


        // 로직
        queueing();

        // 출력
        System.out.print(answer);


    }

    static void queueing() {

        while (!stateQueue.isEmpty()) {

            State state = stateQueue.poll();
            int dir = dirMatrix[state.x][state.y];
            answer = Math.max(answer, state.count);

            for (int i = 1; i < size; i++) {

                int futureRow = state.x + i * dx[dir];
                int futureCol = state.y + i * dy[dir];

                if (!existCheck(futureRow, futureCol)) {
                    break;
                }

                int futureValue = matrix[futureRow][futureCol];
                if (futureValue <= matrix[state.x][state.y])
                    continue;

                stateQueue.add(new State(futureRow, futureCol, state.count + 1));

            }


        }


    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }


}