import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int size = sc.nextInt();
    static int[][] matrix = new int[size][size];


    public static void main(String[] args) {

        for (int i = 0; i < size; i++) {

            String[] stringArray = sc.next().split("");

            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(stringArray[j]);
            }


        }

        int cnt = 0;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {

                if (matrix[i][j] == 1) {
                    press(i, j);
                    cnt++;
                }

            }
        }


        System.out.println(cnt);


    }

    private static void press(int row, int col) {

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {

                matrix[i][j] = Math.abs(matrix[i][j] - 1);

            }
        }


    }


}