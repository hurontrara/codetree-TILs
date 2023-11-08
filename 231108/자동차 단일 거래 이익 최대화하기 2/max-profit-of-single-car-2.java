import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static int[] array = new int[n];
    static int[] maxArray = new int[n];

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int max = -1;
        for (int i = n - 1; i > 0; i--) {
            max = Math.max(max, array[i]);
            maxArray[i] = max;
        }

        int maxValue = 0;
        for (int i = 0; i < n; i++) {

            maxValue = Math.max(maxValue, maxArray[i] - array[i]);

        }

        System.out.println(maxValue);



    }


}