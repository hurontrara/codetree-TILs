import java.io.*;
import java.util.*;

class Point {

    int a = 0;
    int b = 0;
    int c = 0;

    Point(Point pointA, Point pointB, Point pointC, char input) {

        this.a = pointA.a + pointB.a - pointC.a;
        this.b = pointA.b + pointB.b - pointC.b;
        this.c = pointA.c + pointB.c - pointC.c;

        if (input == 'a')
            this.a++;
        else if (input == 'b')
            this.b++;
        else
            this.c++;

    }

    Point() {

    }

}

public class Main {

    static int n, m, q; // n * m의 행렬, q개의 쿼리

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Point[][] matrix;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());
        matrix = new Point[n + 1][m + 1];

        for (int i = 0; i < m + 1; i++) {
            matrix[0][i] = new Point();
        }

        for (int i = 0; i < n + 1; i++) {
            matrix[i][0] = new Point();
        }

        for (int i = 1; i < n + 1; i++) {

            char[] inputArray = br.readLine().toCharArray();
            for (int j = 1; j < m + 1; j++) {

                matrix[i][j] = new Point(matrix[i - 1][j], matrix[i][j - 1], matrix[i - 1][j - 1], inputArray[j - 1]);

            }

        }

        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); int d = Integer.parseInt(st.nextToken());

            Point pointA = matrix[c][d]; Point pointB = matrix[a - 1][d]; Point pointC = matrix[c][b - 1]; Point pointD = matrix[a - 1][b - 1];

            int localA = pointA.a - pointB.a - pointC.a + pointD.a;
            int localB = pointA.b - pointB.b - pointC.b + pointD.b;
            int localC = pointA.c - pointB.c - pointC.c + pointD.c;

            sb.append(localA).append(" ").append(localB).append(" ").append(localC).append("\n");

        }   

        System.out.print(sb);


                

    }




}