import java.io.*;
import java.util.stream.Stream;

public class Main {

    static int size, blockSize, blockCol;
    static int[][] matrix;
    static int firstRow;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sbbArray = br.readLine().split(" ");
        size = Integer.parseInt(sbbArray[0]); blockSize = Integer.parseInt(sbbArray[1]); blockCol = Integer.parseInt(sbbArray[2]) - 1;
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 로직
        findFirstRow();
        InsertBlock();

        // 출력
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void InsertBlock() {

        for (int col = blockCol; col < blockCol + blockSize; col++) {
            matrix[firstRow - 1][col] = 1;
        }

    }

    static void findFirstRow() {

        for (int row = 0; row < size; row++) {

            for (int col = blockCol; col < blockCol + blockSize; col++) {

                if (matrix[row][col] == 1) {
                    firstRow = row;
                    return;
                }

            }

        }

        firstRow = size;


    }


}