import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}


public class Main {

    static int n, m;
    static List<Point> pointList = new ArrayList<>();
    static List<Point> tmpList = new ArrayList<>();

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {


        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" ");
        n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);

        for (int i = 0; i < n; i++) {
            int[] point = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pointList.add(new Point(point[0], point[1]));
        }


        // 로직
        for (int i = 0; i < n; i++) {
            recursive(i, 0);
        }

        // 출력 
        System.out.print(answer);


    }

    static void recursive(int index, int count) {

        // 로직
        // 모든 점에 대하여 거리 계산하고 최소 거리 구하기 -> 최소 거리 제곱값과 answer 비교
        if (index == n && count == m) {
            
            int localMax = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {

                Point firstPoint = tmpList.get(i);

                for (int j = i + 1; j < m; j++) {

                    Point secondPoint = tmpList.get(j);
                    int localDistance = (int) Math.pow(firstPoint.x - secondPoint.x, 2) + (int) Math.pow(firstPoint.y - secondPoint.y, 2);
                    localMax = Math.max(localDistance, localMax);

                }

            }

            answer = Math.min(answer, localMax);


            return;
        }

        if (index == n || count == m) {
            return;
        }

        tmpList.add(pointList.get(index));
        for (int i = index; i < n; i++) {
            recursive(i + 1, count + 1);
        }
        tmpList.remove(tmpList.size() - 1);



    }



}