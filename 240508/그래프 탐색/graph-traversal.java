import java.io.*;

public class Main {

    static int n, m;
    static int[][] matrix;
    static int[] visited;

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
            matrix[end - 1][start - 1] = 1;

        }
        visited[0] = 1;

        // 로직
        dfs(0);

        // 출력
        int answer = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) {
                answer++;
            }
        }
        System.out.println(answer - 1);


    }

    static void dfs(int point) {

        for (int i = 0; i < n; i++) {

            if (matrix[point][i] == 1 && visited[i] == 0) {

                visited[i] = 1;
                dfs(i);



            }


        }



    }

}