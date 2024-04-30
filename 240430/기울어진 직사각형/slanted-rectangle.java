import java.io.*;
import java.util.stream.Stream;
import java.lang.Math;

public class Main {

    static int size;
    static int[][] matrix;

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};

    static int answer = 0;

    public static void main(String[] args) throws Exception{
        
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 로직
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                getNum(i, j);
            }
        }

        System.out.println(answer);


    }

    static void getNum(int row, int col) { 

        // 가로, 세로 사이즈 고정
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - i; j++) {

                getRectangleNum(row, col, i, j);                

            }
        }

    }

    static void getRectangleNum(int row, int col, int nSize, int mSize) {

        int recentRow = row;
        int recentCol = col;
        int localAnswer = 0;

        for (int i = 0; i < nSize; i++) {

            recentRow += dx[0];
            recentCol += dy[0];

            if (inCheck(recentRow, recentCol))
                localAnswer += matrix[recentRow][recentCol];
            else
                return;

        }

        for (int i = 0; i < mSize; i++) {

            recentRow += dx[1];
            recentCol += dy[1];

            if (inCheck(recentRow, recentCol))
                localAnswer += matrix[recentRow][recentCol];
            else
                return;

        }

        for (int i = 0; i < nSize; i++) {

            recentRow += dx[2];
            recentCol += dy[2];

            if (inCheck(recentRow, recentCol))
                localAnswer += matrix[recentRow][recentCol];
            else
                return;

        }

        for (int i = 0; i < mSize; i++) {

            recentRow += dx[3];
            recentCol += dy[3];

            if (inCheck(recentRow, recentCol))
                localAnswer += matrix[recentRow][recentCol];
            else
                return;

        }   

        answer = Math.max(answer, localAnswer);   



    }

    static boolean inCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size);
    }

}