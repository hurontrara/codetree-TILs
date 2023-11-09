import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Point implements Comparable<Point> {

        int count;
        int value;

        Point(int count, int value) {
            this.count = count;
            this.value = value;
        }


        @Override
        public int compareTo(Point point) {
            if (this.value == point.value)
                return this.count - point.count;

            return this.value - point.value;
        }

    }

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static Point[] array = new Point[n];


    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            array[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(array);

        greedy();


    }

    private static void greedy() {

        int left = 0;
        int right = n - 1;

        int maxValue = 0;
        while (left <= right) {

            Point leftPoint = array[left];
            Point rightPoint = array[right];

            maxValue = Math.max(maxValue, leftPoint.value + rightPoint.value);

            int leftCount = leftPoint.count;
            int rightCount = rightPoint.count;

            if (leftCount < rightCount) {
                left++;
                rightPoint.count -= leftCount;
                continue;
            }

            if (leftCount > rightCount) {
                right--;
                leftPoint.count -= rightCount;
                continue;
            }

            left++;
            right--;

        }

        System.out.println(maxValue);


    }


}