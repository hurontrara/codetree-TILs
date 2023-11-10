import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[] array = new int[n];

    public static void main(String[] args) {

        int cnt = 0;
        for (int i = 1; i < n; i++) {

            if (array[i - 1] == 0) {
                press(i);
                cnt++;
            }
        }

        if (array[n - 1] == 1)
            System.out.println(cnt);
        else
            System.out.println(-1);

    }

    private static void press(int index) {

        array[index - 1] = Math.abs(array[index - 1] - 1);
        array[index] = Math.abs(array[index] - 1);

        if (index != n - 1)
            array[index + 1] = Math.abs(array[index + 1] - 1);

    }


}