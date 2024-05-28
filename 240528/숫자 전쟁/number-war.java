import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] aArray;
    static int[] bArray;

    static int[][] dpMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        aArray = new int[n]; bArray = new int[n];
        dpMatrix = new int[n + 1][n + 1];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bArray[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dpMatrix[i][j] = -1;
            }
        }

        // 초기화
        dpMatrix[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (dpMatrix[i][j] == -1)
                    continue;

                int firstRow; int firstCol;
                if (aArray[i] < bArray[j]) { // 값 그대로
                    firstRow = i + 1; firstCol = j;
                    dpMatrix[firstRow][firstCol] = Math.max(dpMatrix[firstRow][firstCol], dpMatrix[i][j]);

                } 
                
                
                else if (aArray[i] > bArray[j]) { // 값 더하기
                    firstRow = i; firstCol = j + 1;
                    dpMatrix[firstRow][firstCol] = Math.max(dpMatrix[firstRow][firstCol], dpMatrix[i][j] + bArray[j]);
                } 
                
                
                
                else {
                    firstRow = i + 1; firstCol = j + 1;
                    dpMatrix[firstRow][firstCol] = Math.max(dpMatrix[firstRow][firstCol], dpMatrix[i][j]);
                }

                int secondRow = i + 1; int secondCol = j + 1;
                dpMatrix[secondRow][secondCol] = Math.max(dpMatrix[secondRow][secondCol], dpMatrix[i][j]);


            }
        }
        
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            answer = Math.max(dpMatrix[n][i], answer);
            answer = Math.max(dpMatrix[i][n], answer);
        }
        System.out.print(answer);


    }

}