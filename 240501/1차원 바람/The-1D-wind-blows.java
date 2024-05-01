import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Wind {
    int row;
    String dir;
    String to;

    Wind(int row, String dir, String to) {
        this.row = row;
        this.dir = dir;
        this.to = to;
    }
}

public class Main {

    static int n, m, time;
    static int[][] matrix;
    static Queue<Wind> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmtArray = br.readLine().split(" ");
        n = Integer.parseInt(nmtArray[0]); m = Integer.parseInt(nmtArray[1]); time = Integer.parseInt(nmtArray[2]);
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 초기 상태
        for (int i = 0; i < time; i++) {
            String[] initialWindArray = br.readLine().split(" ");
            int row = Integer.parseInt(initialWindArray[0]) - 1;
            String dir = initialWindArray[1];

            windProcess(row, dir);

            compare(new Wind(row, dir, "U"));
            compare(new Wind(row, dir, "D"));

            queueProcess();
            


        }


        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void queueProcess() {

        while (!queue.isEmpty()) {
            Wind wind = queue.poll();

            windProcess(wind.row, wind.dir);

            compare(wind);
        }

    }

    static void compare(Wind wind) {

        if (wind.to.equals("U") && wind.row > 0) {
            
            for (int i = 0; i < m; i++) {
                if (matrix[wind.row][i] == matrix[wind.row - 1][i]) {
                    queue.add(new Wind(wind.row - 1, wind.dir.equals("L") ? "R" : "L", "U"));
                    return;
                }
            }


        }

        if (wind.to.equals("D") && wind.row < n - 1) { 

            for (int i = 0; i < m; i++) {
                if (matrix[wind.row][i] == matrix[wind.row + 1][i]) {
                    queue.add(new Wind(wind.row + 1, wind.dir.equals("L") ? "R" : "L", "D"));
                    return;
                }
            }

        }



    }


    static void windProcess(int row, String dir) {
        
        if (dir.equals("L")) {
            int tmp = matrix[row][m - 1];
            for (int i = m - 1; i > 0; i--) {
                matrix[row][i] = matrix[row][i - 1];
            }
            matrix[row][0] = tmp;

        } else {
            int tmp = matrix[row][0];
            for (int i = 0; i < m - 1; i++) {
                matrix[row][i] = matrix[row][i + 1];
            }
            matrix[row][m - 1] = tmp;
        }

    }


}