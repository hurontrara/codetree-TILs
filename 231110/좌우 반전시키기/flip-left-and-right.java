import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[] array = new int[n];

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }


        int cnt = 0;
        for (int i = 1; i < n; i++) {

            if (array[i - 1] == 0) {
                press(i);
                cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (array[i] != 1) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        System.out.println(cnt);
    }

    private static void press(int index) {

        array[index - 1] = Math.abs(array[index - 1] - 1);
        array[index] = Math.abs(array[index] - 1);

        if (index != n - 1)
            array[index + 1] = Math.abs(array[index + 1] - 1);

    }


}