import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Point implements Comparable<Point> {

        String value;
        int typeOneCount;
        int typeTwoCount;

        Point(String value, int typeOneCount, int typeTwoCount) {
            this.value = value;
            this.typeOneCount = typeOneCount;
            this.typeTwoCount = typeTwoCount;
        }

        public int compareTo(Point point) {

            long leftScore = (long) this.typeOneCount * point.typeTwoCount;
            long rightScore = (long) this.typeTwoCount * point.typeOneCount;

            if (leftScore > rightScore)
                return -1;

            if (leftScore == rightScore)
                return 0;

            return 1;

        }


    }

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static Point[] pointArray = new Point[n];

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            String input = sc.next();

            String[] split = input.split("");

            int leftCount = 0;
            int rightCount = 0;
            for (String s : split) {

                if (s.equals("("))
                    leftCount++;
                else
                    rightCount++;

            }

            pointArray[i] = new Point(input, leftCount, rightCount);


        }

        Arrays.sort(pointArray);

        int leftCount = 0;
        long totalNum = 0;
        for (Point point : pointArray) {

            String[] split = point.value.split("");

            for (String s : split) {

                if (s.equals("("))
                    leftCount++;
                else
                    totalNum += leftCount;

            }

        }

        System.out.println(totalNum);



    }


}