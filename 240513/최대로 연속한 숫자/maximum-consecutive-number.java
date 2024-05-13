import java.io.*;
import java.util.*;

class State implements Comparable<State> {

    int x;
    int distance;

    State(int x, int distance) {

        this.x = x;
        this.distance = distance;
    }

    @Override
    public int compareTo(State state) {

        return this.x - state.x;

    }

    State(int x) {
        this.x = x;
    }


}


public class Main {

    static int n, m; // 0 ~ n까지의 수열, m개의 인풋

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<State> treeSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        treeSet.add(new State(n + 1, n + 1));
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {

            int answer = 0;
            int value = Integer.parseInt(st.nextToken());

            State newState = new State(value);
            treeSet.add(newState);
            newState.distance = treeSet.lower(newState) == null ? value : (value - treeSet.lower(newState).x - 1);

            State afterState = treeSet.higher(newState);
            afterState.distance = afterState.x - value - 1;


            for (State state : treeSet) {
                answer = Math.max(answer, state.distance);
            }

            sb.append(answer).append("\n");

        }

        System.out.print(sb);

    }
}