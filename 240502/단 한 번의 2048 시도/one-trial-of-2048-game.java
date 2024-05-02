import java.io.*;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static int[][] matrix = new int[4][4];
    static String dir;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dir = br.readLine();

        // 로직
        int rotateTime = dir.equals("D") ? 0 : dir.equals("R") ? 1 : dir.equals("U") ? 2 : 3;

        for (int i = 0; i < rotateTime; i++) {
            rotate();
        }
        gravity();
        for (int i = 0; i < (4 - rotateTime) % 4; i++) {
            rotate();
        }

        // 출력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }



    }

    static void gravity() {

        int[] tempArray = new int[4];
        int[] secondTempArray = new int[4];
        int idx;

        
        for (int col = 0; col < 4; col++) {

            idx = 3;
            for (int row = 3; row >= 0; row--) {
                
                if (matrix[row][col] != 0)
                    tempArray[idx--] = matrix[row][col];
            }


            idx = 3;
            for (int i = 3; i >= 0; i--) {

                if (i == 0) {
                    secondTempArray[idx--] = tempArray[i];
                    break;
                }

                if (tempArray[i] == tempArray[i - 1]) {
                    secondTempArray[idx--] = tempArray[i] * 2;
                    i--;
                } else {
                    secondTempArray[idx--] = tempArray[i];
                }
            }

            for (int row = 0; row < 4; row++) {
                matrix[row][col] = secondTempArray[row];
            }

            for (int i = 0; i < 4; i++) {
                tempArray[i] = 0;
            }

        }

        // 




    }

    // 90도 회전
    static void rotate() {

        for (int col = 0; col < 4; col++) {
            for (int row = 3; row >= 0; row--) {
                queue.add(matrix[row][col]);
            }
        }

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                matrix[row][col] = queue.poll();
            }
        }



    }


    


}