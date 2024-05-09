import java.io.*;
import java.util.stream.Stream;
import java.util.*;

class Point {

    int x; 
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Stone {

    int x;
    int y;

    Stone(int x, int y) {
        this.x = x;
        this.y = y;
    }

}


public class Main {

    static int size, k, m;
    static int[][] matrix;
    static int[][] visited;

    static List<Stone> stoneList = new ArrayList<>();
    static List<Point> startPointList = new ArrayList<>();

    static List<Stone> tmpStoneList = new ArrayList<>();

    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int answer = 0;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] skArray = br.readLine().split(" ");
        size = Integer.parseInt(skArray[0]); k = Integer.parseInt(skArray[1]); m = Integer.parseInt(skArray[2]);
        matrix = new int[size][size]; visited = new int[size][size];

        // matrix 초기화 및 stone 값 저장
        for (int i = 0; i < size; i++) {
            int[] array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = array;
            for (int j = 0; j < size; j++) {

                if (array[j] == 1) {
                    stoneList.add(new Stone(i, j));
                }

            }

        }

        // 시작 좌표 값 저장
        for (int i = 0; i < k; i++) {

            String[] pointArray = br.readLine().split(" ");
            startPointList.add(new Point(Integer.parseInt(pointArray[0]) - 1, Integer.parseInt(pointArray[1]) - 1));

        }


        // 로직
        // stoneList.size() 개의 돌 중 m개를 고르는 경우의 수
        for (int i = 0; i <= stoneList.size(); i++) {

            backTracking(i, 0);

        }


        // 출력
        System.out.print(answer);

    }

    static void backTracking(int index, int count) {

        // 로직
        // tmpStoneList에 치워야 할 돌들 들어가 있는 상태
        // 돌 치우고 시작점들에 대하여 BFS
        // visited 초기화 하면서 카운트
        // stone 복원
        if (index == stoneList.size() && count == m) {

            // 돌 치우기
            for (Stone stone : tmpStoneList) {
                matrix[stone.x][stone.y] = 0;
            }

            // BFS
            for (Point point : startPointList) {
                visited[point.x][point.y] = 1;
                queue.add(point);
            }
            bfs();

            // visited 초기화 및 카운트
            int cnt = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    if (visited[i][j] == 1) {
                        cnt++;
                        visited[i][j] = 0;
                    }

                }
            }
            answer = Math.max(answer, cnt);

            // 복원
            for (Stone stone : tmpStoneList) {
                matrix[stone.x][stone.y] = 1;
            }

            return;


        }

        // 안 맞는 것들 쳐내기
        if (index == stoneList.size() || count == m) {
            return;
        }

        tmpStoneList.add(stoneList.get(index));
        for (int i = index; i < stoneList.size(); i++) {

            backTracking(i + 1, count + 1);

        }
        tmpStoneList.remove(tmpStoneList.size() - 1);



    }


    static void bfs() {

        while (!queue.isEmpty()) {

            Point point = queue.poll();


            for (int dir = 0; dir < 4; dir++) {

                int futureRow = point.x + dx[dir];
                int futureCol = point.y + dy[dir];

                if (canGo(futureRow, futureCol)) {

                    queue.add(new Point(futureRow, futureCol));
                    visited[futureRow][futureCol] = 1;

                }

            }


        }



    }

    static boolean canGo(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] == 0 && visited[row][col] == 0;
    }


}