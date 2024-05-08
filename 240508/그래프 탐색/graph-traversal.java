import java.io.*;
import java.util.stream.Stream;
import java.util.*;


public class Main {

    static int n, m;
    static int[][] matrix;
    static int[] visited;

    static int answer = 0;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" ");
        n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);
        
        // n은 노드, m은 간선
        matrix = new int[n][n];
        visited = new int[n];

        // matrix에 간선 기록
        for (int i = 0; i < m; i++) {
            String[] edgeArray = br.readLine().split(" ");
            int start = Integer.parseInt(edgeArray[0]);
            int end = Integer.parseInt(edgeArray[1]);
            matrix[start - 1][end - 1] = 1;
        }

        // 로직
        dfs(0, 0);

        // 출력 
        System.out.print(answer);


    }

    static void dfs(int point, int count) {

        for (int i = 0; i < n; i++) {

            if (matrix[point][i] == 1 && visited[i] == 0) {

                visited[i] = 1;
                answer = Math.max(answer, count + 1);
                dfs(i, count + 1);



            }


        }



    }

}