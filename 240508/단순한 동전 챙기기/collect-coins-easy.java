import java.io.*;
import java.util.stream.Stream;
import java.util.*;

class Point implements Comparable<Point> {
    
    int x;
    int y;
    int number;

    Point(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }

    @Override
    public int compareTo(Point point) {
        return this.number - point.number;
    }

}



public class Main {

    static int size;
    static int[][] matrix;

    static int answer = Integer.MAX_VALUE;

    static List<Point> numList = new ArrayList<>();
    static List<Point> tmpList = new ArrayList<>();

    static int startRow, startCol, endRow, endCol;

    public static void main(String[] args) throws Exception {
        // 초기화
        // 숫자 배열 생성 및 어디에 있는지 라벨링
        // . -> 0

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());


        for (int i = 0; i < size; i++) {
            String[] stringArray = br.readLine().split("");

            for (int j = 0; j < size; j++) {

                String string = stringArray[j];

                if (string.equals(".")) {
                    continue;
                } else if (string.equals("S")) {
                    startRow = i; startCol = j;
                } else if (string.equals("E")) {
                    endRow = i; endCol = j;
                } else {
                    numList.add(new Point(i, j, Integer.parseInt(string)));
                }

            }

        }

        if (numList.size() < 3) {
            System.out.println(-1);
            System.exit(0);
        }  

        Collections.sort(numList);

        // 로직
        for (int i = 0; i < numList.size(); i++) {
            recursive(i, 0);
        }

        // 출력
        System.out.print(answer);




    }

    static void recursive(int index, int count) {

        // 거리 작성
        if (index == numList.size() && count == 3) {

            int currentRow = startRow;
            int currentCol = startCol;
            int cnt = 0;

            for (int i = 0; i < 3; i++) {
                Point point = tmpList.get(i);

                cnt += Math.abs(currentRow - point.x) + Math.abs(currentCol - point.y);

                currentRow = startRow;
                currentCol = startCol;
            }

            cnt += Math.abs(currentRow - endRow) + Math.abs(currentCol - endCol);

            answer = Math.min(answer, cnt);

            return;
        }

        // 필요없는 것 버리기
        if (index == numList.size() || count == 3) {
            return;
        }

        tmpList.add(numList.get(index));
        for (int i = index; i < numList.size(); i++) {
            recursive(i + 1, count + 1);
        }
        tmpList.remove(tmpList.size() - 1);


    }




}