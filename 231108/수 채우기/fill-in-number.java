import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    public static void main(String[] args) {

        greedy();

    }

    private static void greedy() {

        int cnt = 0;
        int restValue = n;

        if (n < 5 || n == 8) {
            System.out.println(-1);
            System.exit(0);
        }

        if (n % 5 == 1 || n % 5 == 3) {
            cnt += (restValue / 5) - 1;
            restValue -= 5 * cnt;

            cnt += restValue / 2;
            System.out.println(cnt);
            System.exit(0);
        }

        cnt += restValue / 5;
        restValue -= 5 * cnt;
        cnt += restValue / 2;
        System.out.println(cnt);




    }


}