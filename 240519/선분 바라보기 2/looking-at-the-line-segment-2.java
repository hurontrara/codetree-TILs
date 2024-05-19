import java.io.*;
import java.util.*;

class NewPoint implements Comparable<NewPoint> {

    int x;
    int y;
    int coef;
    int num;


    NewPoint(int x, int y, int coef, int num) {
        this.x = x;
        this.y = y;
        this.coef = coef;
        this.num = num;
    }

    @Override
    public int compareTo(NewPoint point) {

        if (this.y == point.y)
            return this.x - point.x;

        return this.y - point.y;

    }

}


class Point implements Comparable<Point> {

    int x;
    int y;
    int coef;
    int num;


    Point(int x, int y, int coef, int num) {
        this.x = x;
        this.y = y;
        this.coef = coef;
        this.num = num;
    }

    @Override
    public int compareTo(Point point) {

        return this.x - point.x;

    }

}


public class Main {

    static int n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<Point> pointList = new ArrayList<>();

    static TreeSet<NewPoint> presentSet = new TreeSet<>(); // y값 저장
    static HashSet<Integer> answerSet = new HashSet<>(); // 정답값 저장

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken()); int x1 = Integer.parseInt(st.nextToken()); int x2 = Integer.parseInt(st.nextToken());

            pointList.add(new Point(x1, y, 1, i)); pointList.add(new Point(x2, y, -1, i));

        }

        Collections.sort(pointList);


        for (Point point : pointList) {

            if (point.coef == 1) {

                NewPoint newPoint = new NewPoint(point.x, point.y, point.coef, point.num);

                presentSet.add(newPoint);

                if (presentSet.first() == newPoint) {
                    answerSet.add(point.num);
                }

            }

            else {

                NewPoint newPoint = presentSet.higher(new NewPoint(-1, point.y, -1, -1));

                presentSet.remove(newPoint);

                if (!presentSet.isEmpty() && presentSet.lower(newPoint) == null) {

                    answerSet.add(presentSet.first().num);

                }



            }

        }
        
        System.out.print(answerSet.size());



    }



}