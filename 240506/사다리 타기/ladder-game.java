import java.io.*;
import java.util.stream.Stream;
import java.util.*;


class Line implements Comparable<Line> {

    int col;
    int row;

    Line (int col, int row) {
        this.col = col;
        this.row = row;
    }

    @Override
    public int compareTo(Line line) {
        return this.row - line.row;
    }


}

public class Main {

    static int personNum, lineNum;
    static List<Line> lineList = new ArrayList<>();
    static List<Line> tmpLineList = new ArrayList<>();
    static int[] personArray;
    static int[] tmpPersonArray;
    static int answer = 1000000000;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] plArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        personNum = plArray[0]; lineNum = plArray[1];

        for (int i = 0; i < lineNum; i++) {
           int[] lineArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
           int col = lineArray[0] - 1; int row = lineArray[1] - 1;
           lineList.add(new Line(col, row));
        }

        // 라인들 정렬
        Collections.sort(lineList);

        // 초기 배열 세팅
        personArray = new int[personNum];
        tmpPersonArray = new int[personNum];
        for (int i = 0; i < personNum; i++) {
            personArray[i] = i + 1;
            tmpPersonArray[i] = i + 1;
        }
        for (int i = 0; i < lineList.size(); i++) {
            Line line = lineList.get(i);
            personChange(line.col, personArray);
        }

        // 로직
        for (int i = 0; i <= lineList.size(); i++)  {
            recursive(i);
        }

        // 출력
        System.out.print(answer);




    }

    static void recursive(int index) {

        if (index >= lineNum) {

            for (int i = 0; i < tmpLineList.size(); i++) {
                Line line = tmpLineList.get(i);
                personChange(line.col, tmpPersonArray);
            }

            sameCheck();

            // tmpLineList 초기화
            for (int i = 0; i < personNum; i++) {
                tmpPersonArray[i] = i + 1;
            }

            return;


        }


        tmpLineList.add(lineList.get(index));
        for (int i = index; i < lineNum; i++) {

            recursive(i + 1);

        }
        tmpLineList.remove(tmpLineList.size() - 1);



    }

    static void sameCheck() {

        for (int i = 0; i < personNum; i++) {

            if (tmpPersonArray[i] != personArray[i])
                return;

        }

        answer = Math.min(answer, tmpLineList.size());


    }


    static void personChange(int col, int[] array) {

        int tmp = array[col + 1];
        array[col + 1] = array[col];
        array[col] = tmp;

    }

}