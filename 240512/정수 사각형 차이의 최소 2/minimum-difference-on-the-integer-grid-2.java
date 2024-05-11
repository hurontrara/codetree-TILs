import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class State {

    int min;
    int max;

    State(int min, int max) {
        this.min = min;
        this.max = max;
    }


}


public class Main {

    static int size;
    static int[][] matrix;
    static State[][] dpMatrix;

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine()); matrix = new int[size][size]; dpMatrix = new State[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dpMatrix[0][0] = new State(matrix[0][0], matrix[0][0]);


        int min; int max; int value; State beforeState;
        for (int i = 1; i < size; i++) {

            beforeState = dpMatrix[i - 1][0];
            min = beforeState.min; max = beforeState.max; value = matrix[i][0];
            if (value > max) {
                max = value;
            } else if (value < min) {
                min = value;
            }
            dpMatrix[i][0] = new State(min, max);


            beforeState = dpMatrix[0][i - 1];
            min = beforeState.min; max = beforeState.max; value = matrix[0][i];
            if (value > max) {
                max = value;
            } else if (value < min) {
                min = value;
            }
            dpMatrix[0][i] = new State(min, max);




        }


        // logic
        State state = memo(size - 1, size - 1);
        
        // print
        System.out.print(state.max - state.min);



    }

    static State memo(int row, int col) {

        if (dpMatrix[row][col] != null)
            return dpMatrix[row][col];

        State firstState = memo(row - 1, col);
        State secondState = memo(row, col - 1);

        int firstMin = firstState.min; int firstMax = firstState.max; int secondMin = secondState.min; int secondMax = secondState.max;
        int value = matrix[row][col];

        if (firstMin > value)
            firstMin = value;
        if (firstMax < value)
            firstMax = value;
        if (secondMin > value)
            secondMin = value;
        if (secondMax < value)
            secondMax = value;

        if (firstMax - firstMin < secondMax - secondMin) {
            dpMatrix[row][col] = new State(firstMin, firstMax);
        } else {
            dpMatrix[row][col] = new State(secondMin, secondMax);
        }

        return dpMatrix[row][col];


    }


}