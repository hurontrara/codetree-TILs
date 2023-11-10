import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static String nString = sc.next();
    static String mString = sc.next();

    static List<Integer> changeList = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            if (nString.charAt(i) != mString.charAt(i))
                changeList.add(i);
        }

        greedy();



    }

    private static void greedy() {

        if (changeList.size() == 0) {
            System.out.println(0);
            System.exit(0);
        }

        int cnt = 1;
        int localCount = 1;

        for (int i = 1; i < changeList.size(); i++) {

            if (localCount == 4) {
                cnt++;
                localCount = 1;
                continue;
            }

            int leftValue = changeList.get(i - 1);
            int rightValue = changeList.get(i);

            if (rightValue - 1 == leftValue) {
                localCount++;
                continue;
            }

            cnt++;
            localCount = 1;


        }

        System.out.println(cnt);




    }


}