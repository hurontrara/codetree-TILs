import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    public static void main(String[] args) {

        greedy();

    }

    private static int greedy() {

        int cnt = 0;
        int restValue = n;

        if (n == 1) {
            System.out.println(-1);
            return 0;
        }

        if (n % 5 == 1) {
            cnt += (n / 5) - 1;
            restValue -= 5 * cnt;
            cnt += (restValue / 2);
            System.out.println(cnt);
            return 0;
        }

        cnt += (restValue / 5);
        restValue -= 5 * cnt;

        int twoCount = restValue / 2;
        cnt += twoCount;
        restValue -= twoCount * 2;

        if (restValue != 0)
            System.out.println(-1);
        else
            System.out.println(cnt);

        return 0;


    }


}