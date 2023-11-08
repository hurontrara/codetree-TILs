import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static class Point implements Comparable<Point> {

        int value;

        Point(int value) {
            this.value = value;
        }

        public int compareTo(Point point) {

            String formerString = String.valueOf(this.value);
            String latterString = String.valueOf(point.value);

            String formerLatterString = formerString + latterString;
            String latterFormerString = latterString + formerString;


            return Integer.parseInt(latterFormerString) - Integer.parseInt(formerLatterString);
        }


    }


    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static TreeSet<Point> treeSet = new TreeSet<>();



    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            treeSet.add(new Point(sc.nextInt()));
        }

        for (Point point : treeSet) {
            System.out.print(point.value);
        }

    }


}