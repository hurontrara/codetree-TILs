import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        int length = 0;
        for (int i = 0; i < n; i++) {

            int x = sc.nextInt();
            length += x;
            int y = sc.nextInt();


            for (int j = 0; j < x; j++) {
                list.add(y);
            }

        }

        list.sort((num1, num2) -> num1 - num2);

        int maxValue = 0;
        for (int i = 0; i <= length / 2 - 1; i++) {

            int leftValue = list.get(i);
            int rightValue = list.get(length - i - 1);

            maxValue = Math.max(maxValue, leftValue + rightValue);

        }

        System.out.println(maxValue);


    }
}