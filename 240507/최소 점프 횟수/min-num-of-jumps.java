import java.io.*;
import java.util.stream.Stream;
import java.util.*;

class State {

    int x;
    int count;

    State (int x, int count) {
        this.x = x;
        this.count = count;
    }

}


public class Main {

    static int[] matrix;
    static int size;
    static Queue<State> stateQueue = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        stateQueue.add(new State(0, 0));

        // 로직
        queueing();

        // 출력
        System.out.print(answer);


    }

    static void queueing() {

        while (!stateQueue.isEmpty()) {

            State state = stateQueue.poll();

            if (state.x >= size)
                continue;
            
            if (state.x == size - 1) {
                answer = Math.min(answer, state.count);
                continue;
            }

            int jump = matrix[state.x];

            for (int i = 1; i <= jump; i++) {
                stateQueue.add(new State(state.x + i, state.count + 1));
            }




        }


    }


}