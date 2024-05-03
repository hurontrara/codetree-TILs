import java.io.*;
import java.util.*;

class Head {

    int x;
    int y;

    Head(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int size, appleNum, dirChange;
    static int[][] matrix;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] headMatrix;

    static List<Integer> dirList = new ArrayList<>();
    static List<Head> headList = new ArrayList<>();

    static int answer = -1;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split(" ");
        size = Integer.parseInt(array[0]); appleNum = Integer.parseInt(array[1]); dirChange = Integer.parseInt(array[2]);
        matrix = new int[size][size];
        headMatrix = new int[size][size];
        for (int i = 0; i < appleNum; i++) {
            String[] appleArray = br.readLine().split(" ");
            int appleRow = Integer.parseInt(appleArray[0]) - 1; int appleCol = Integer.parseInt(appleArray[1]) - 1;
            matrix[appleRow][appleCol] = 1;
        }
        for (int i = 0; i < dirChange; i++) {
            String[] dirArray = br.readLine().split(" ");
            String dirString = dirArray[0]; int dirTimes = Integer.parseInt(dirArray[1]);
            for (int j = 0; j < dirTimes; j++) {
                int dirInt = dirString.equals("D") ? 0 : dirString.equals("R") ? 1 : dirString.equals("U") ? 2 : 3;
                dirList.add(dirInt);
            }
        }
        headList.add(new Head(0, 0));


        // 로직
        for (int i = 0; i < dirList.size(); i++) {
            move(i);
        }
        System.out.print(dirList.size());


    }

    static void move(int time) {

        int dir = dirList.get(time);
        Head head = headList.get(0);
        int futureRow = head.x + dx[dir];
        int futureCol = head.y + dy[dir];

        int localDir = -1;


        if (!existCheck(futureRow, futureCol)) {
            System.out.print(time + 1);
            System.exit(0);
        }

        // 움직이고
        for (int i = 0; i < headList.size(); i++) {
            localDir = dirList.get(time - i);
            Head localHead = headList.get(i);
            localHead.x += dx[localDir];
            localHead.y += dy[localDir];
        }

        // 사과 있으면 추가
        if (matrix[futureRow][futureCol] == 1) {
            matrix[futureRow][futureCol] = 0;

            Head lastHead = headList.get(headList.size() - 1);
            int newHeadDir = (localDir + 2) % 4;
            headList.add(new Head(lastHead.x + dx[newHeadDir], lastHead.y + dy[newHeadDir]));

        }

        // 꼬여있으면 끝
        for (int i = 0; i < headList.size(); i++) {
            Head ahead = headList.get(i);
            if (headMatrix[ahead.x][ahead.y] == 1) {
                System.out.println(time + 1);
                System.exit(0);
            }
            headMatrix[ahead.x][ahead.y] = 1;

        }

        // 안꼬여있으면 복구
        for (int i = 0; i < headList.size(); i++) {
            Head bhead = headList.get(i);
            headMatrix[bhead.x][bhead.y] = 0;
        }




    }

    static boolean existCheck(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }


}