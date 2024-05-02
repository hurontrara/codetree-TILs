import java.io.*;
import java.util.stream.Stream;

class Dice {

    int type1 = 1;
    int type2 = 4;
    int type3 = 2;
    int type4 = 3;
    int type5 = 5;
    int type6 = 6;

    void shift(String dir) {

        int tmpType1 = type1;
        int tmpType2 = type2;
        int tmpType3 = type3;
        int tmpType4 = type4;
        int tmpType5 = type5;
        int tmpType6 = type6;

        if (dir.equals("L")) {
            type1 = tmpType4;
            type2 = tmpType1;
            type4 = tmpType6;
            type6 = tmpType2;
        }

        if (dir.equals("R")) {
            type1 = tmpType2;
            type2 = tmpType6;
            type4 = tmpType1;
            type6 = tmpType4;
        }

        if (dir.equals("U")) {
            type1 = tmpType3;
            type3 = tmpType6;
            type5 = tmpType1;
            type6 = tmpType5;
        }

        if (dir.equals("D")) {
            type1 = tmpType5;
            type3 = tmpType1;
            type5 = tmpType6;
            type6 = tmpType3;
        }


    }

}

public class Main {

    static int size, time, startRow, startCol;
    static int[][] matrix;
    static Dice dice = new Dice();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int answer = 0;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stArray = br.readLine().split(" ");
        size = Integer.parseInt(stArray[0]); time = Integer.parseInt(stArray[1]); startRow = Integer.parseInt(stArray[2]) - 1; startCol = Integer.parseInt(stArray[3]) - 1;
        matrix = new int[size][size];
        matrix[startRow][startCol] = 6;
        String[] dirArray = br.readLine().split(" ");

        //로직
        for (int i = 0; i < time; i++) {

            String dir = dirArray[i];

            rolling(dir); // 주사위 포지션 바꾸고, 행/열 바꾸기
            stamping(); // 찍기

        }

        // 출력
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                answer += matrix[i][j];
            }
        }
        System.out.print(answer);

    }

    static void stamping() {

        matrix[startRow][startCol] = dice.type6;

    }

    static void rolling(String dir) {

        int intDir = dir.equals("L") ? 0 : dir.equals("R") ? 1 : dir.equals("U") ? 2 : 3;

        if (existCheck(startRow + dx[intDir], startCol + dy[intDir])) {
            
            dice.shift(dir);

            startRow += dx[intDir]; startCol += dy[intDir];
        }

    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }



}