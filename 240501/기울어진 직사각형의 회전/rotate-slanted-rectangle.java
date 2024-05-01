import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static int size;
    static int[][] matrix;
    static int row, col, firstStep, secondStep, dir;

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};

    static int[] array;

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        String[] rcArray = br.readLine().split(" ");
        row = Integer.parseInt(rcArray[0]) - 1; col = Integer.parseInt(rcArray[1]) - 1;
        firstStep = Integer.parseInt(rcArray[2]); secondStep = Integer.parseInt(rcArray[3]); dir = Integer.parseInt(rcArray[6]);
        array = new int[firstStep * 2 + secondStep * 2];

        // 로직
        rotate(row, col, firstStep, secondStep, dir);


        // 출력
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) { 
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        



    }

    static void rotate(int row, int col, int firstStep, int secondStep, int dir) {

        // 회전
        int idx = 0;
        int currentRow = row;
        int currentCol = col;

        for (int i = 0; i < firstStep; i++) {
            currentRow += dx[0];
            currentCol += dy[0];
            array[idx++] = matrix[currentRow][currentCol];
        }

        for (int i = 0; i < secondStep; i++) {
            currentRow += dx[1];
            currentCol += dy[1];
            array[idx++] = matrix[currentRow][currentCol];
        }

        for (int i = 0; i < firstStep; i++) {
            currentRow += dx[2];
            currentCol += dy[2];
            array[idx++] = matrix[currentRow][currentCol];
        }

        for (int i = 0; i < secondStep; i++) {
            currentRow += dx[3];
            currentCol += dy[3];
            array[idx++] = matrix[currentRow][currentCol];
        }

        // 배열 회전
        if (dir == 1) {
            int tmp = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = tmp;
        } else {
            int tmp = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = tmp;
        }
        
        // 회전된 값 붙이기
        idx = 0;
        currentRow = row;
        currentCol = col;

        for (int i = 0; i < firstStep; i++) {
            currentRow += dx[0];
            currentCol += dy[0];
            matrix[currentRow][currentCol] = array[idx++];
        }

        for (int i = 0; i < secondStep; i++) {
            currentRow += dx[1];
            currentCol += dy[1];
            matrix[currentRow][currentCol] = array[idx++];
        }

        for (int i = 0; i < firstStep; i++) {
            currentRow += dx[2];
            currentCol += dy[2];
            matrix[currentRow][currentCol] = array[idx++];
        }

        for (int i = 0; i < secondStep; i++) {
            currentRow += dx[3];
            currentCol += dy[3];
            matrix[currentRow][currentCol] = array[idx++];
        }


    }



}