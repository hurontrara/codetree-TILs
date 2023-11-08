import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static int[] bArray = new int[n];

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {

        for (int i = 1; i <= 2 * n; i++) {
            treeSet.add(i);
        }

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();
            bArray[i] = value;
            treeSet.remove(value);

        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {

            Integer higher = treeSet.higher(bArray[i]);

            if (higher == null)
                continue;

            cnt++;
            treeSet.remove(higher);

        }

        System.out.println(cnt);





    }


}