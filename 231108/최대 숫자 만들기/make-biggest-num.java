import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static class Point implements Comparable<Point> {

        int value;
        int number;

        Point(int value, int number) {
            this.value = value;
            this.number = number;
        }

        public int compareTo(Point point) {

            if (this.value == point.value) {
                return this.number - point.number;
            }

            String formerString = Integer.toString(this.value);
            String latterString = Integer.toString(point.value);

            String formerLatterString = formerString + latterString;
            String latterFormerString = latterString + formerString;


            return latterFormerString.compareTo(formerLatterString);
        }


    }


    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static TreeSet<Point> treeSet = new TreeSet<>();



    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            treeSet.add(new Point(sc.nextInt(), i));
        }

        for (Point point : treeSet) {
            System.out.print(point.value);
        }

    }


}