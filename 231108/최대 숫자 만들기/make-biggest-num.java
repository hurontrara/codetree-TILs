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


            return Long.compare(Long.parseLong(latterFormerString), Long.parseLong(formerLatterString));
        }


    }


    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static TreeSet<Point> treeSet = new TreeSet<>();



    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            treeSet.add(new Point(sc.nextInt()));
        }

        while (!treeSet.isEmpty()) {
            System.out.print(treeSet.first().value);
            treeSet.remove(treeSet.first());
        }


    }


}