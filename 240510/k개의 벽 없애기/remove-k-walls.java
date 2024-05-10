import java.io.*;
import java.util.stream.Stream;
import java.util.*;

class Block {

    int x;
    int y;

    Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

}



class Point {

    int x;
    int y;
    int distance;

    Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

}


public class Main {

    static int size, k, startRow, startCol, endRow, endCol;
    static int[][] matrix;
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int answer = Integer.MAX_VALUE;

    static List<Block> blockList = new ArrayList<>();

    static List<Block> tmpList = new ArrayList<>();

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] skArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        size = skArray[0]; k = skArray[1]; matrix = new int[size][size]; visited = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] startPointArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        startRow = startPointArray[0] - 1; startCol = startPointArray[1] - 1;
        int[] endPointArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        endRow = endPointArray[0] - 1; endCol = endPointArray[1] - 1;

        // logic
        // 블록 리스트에 블록을 담고
        // 블록 리스트 중 k개를 선택하는 경우의 수
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1) {
                    blockList.add(new Block(i, j));
                }
            }
        }

        for (int i = 0; i <= blockList.size(); i++) {
            recursive(i, 0);
        }

        // print
        if (answer == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(answer);
        }

        


    }
    
    static void recursive(int index, int count) {

        // 로직
        // tmpList에 치워야 할 블록이 담겨있는 상태 (다시 채워야 함) + visited 초기화
        // ANSWER = 21억이면 -1 출력
        if (index == blockList.size() && count == k) {

            for (Block block : tmpList) {
                matrix[block.x][block.y] = 0;
            }

            queue.add(new Point(startRow, startCol, 0));
            visited[startRow][startCol] = 1;
            bfs();

            for (Block block : tmpList) {
                matrix[block.x][block.y] = 1;
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    visited[i][j] = 0;
                }
            }

            
            return;
        }

        // 필요없는 것 쳐내기
        if (index == blockList.size() || count == k)
            return;

        tmpList.add(blockList.get(index));
        for (int i = index; i < blockList.size(); i++) {
            recursive(i + 1, count + 1);
        }
        tmpList.remove(tmpList.size() - 1);
        
    }


    static void bfs() {

        int count = 0;
        while (!queue.isEmpty()) {

            Point point = queue.poll();

            if (point.x == endRow && point.y == endCol) {
                count = point.distance;
                queue.clear();
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int futureRow = point.x + dx[dir];
                int futureCol = point.y + dy[dir];

                if (canGo(futureRow, futureCol)) {
                    queue.add(new Point(futureRow, futureCol, point.distance + 1));
                    visited[futureRow][futureCol] = 1;
                }
            }


        }

        if (count != 0) {
            answer = Math.min(answer, count);
        }


    }

    static boolean canGo(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] == 0 && visited[row][col] == 0;
    }



}