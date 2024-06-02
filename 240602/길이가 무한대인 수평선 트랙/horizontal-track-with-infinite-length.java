import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static class Human implements Comparable<Human> {

        int firstPosition;
        int speed;
        long lastPosition;

        Human(int firstPosition, int speed) {
            this.firstPosition = firstPosition;
            this.speed = speed;
            this.lastPosition = firstPosition + (long) speed * t;
        }

        public int compareTo(Human human) {

            return this.firstPosition - human.firstPosition;

        }


    }


    static int n, t;
    static TreeSet<Human> treeSet = new TreeSet<>();



    public static void main(String[] args) {
        setting();

        compareProcess();
    }

    private static void compareProcess() {

        Human human = treeSet.last();
        long minPosition = human.lastPosition;
        int cnt = 0;

        while (treeSet.lower(human) != null) {

            Human frontHuman = treeSet.lower(human);

            if (minPosition <= frontHuman.lastPosition)
                cnt++;

            human = frontHuman;


        }

        System.out.println(n - cnt);



    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = sc.nextInt();

        for (int i = 0; i < n; i++) {
            treeSet.add(new Human(sc.nextInt(), sc.nextInt()));
        }


    }


}