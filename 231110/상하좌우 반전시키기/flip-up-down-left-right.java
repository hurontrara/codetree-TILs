import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[][] matrix = new int[n][n];

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i - 1][j] == 0) {
                    press(i, j);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(cnt);


    }

    private static void press(int row, int col) {

        matrix[row][col] = Math.abs(matrix[row][col] - 1);

        for (int dir = 0; dir < 4; dir++) {

            int postRow = row + dx[dir];
            int postCol = col + dy[dir];

            if (existence(postRow, postCol))
                matrix[postRow][postCol] = Math.abs(matrix[postRow][postCol] - 1);
        }


    }

    private static boolean existence(int row, int col) {

        return (row >= 0 && row < n && col >= 0 && col < n);
    }


}