import java.io.*;
import java.util.*;
import java.util.stream.Stream;


public class Main {

    static int size;
    static int[][] matrix;
    static int[] visited;

    static int answer = Integer.MAX_VALUE;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new int[size - 1];

        // 로직
        // 가령 n = 4 ? 0번 지점 출발 -> 순회 -> 0번 지점 도착 : 1 2 3 섞는거
        // n = 5 : 1 2 3 4 섞는거

        recursive(0);

        System.out.print(answer);


    }

    static void recursive(int index) {

        // 거리 계산
        if (index == size - 1) {

            int cnt = 0;

            int present = 0;
            for (int i = 0; i < size - 1; i++) {

                int future = list.get(i);

                cnt += matrix[present][future];

                present = future;

            }
            
            cnt += matrix[present][0];

            answer = Math.min(answer, cnt);

            return;
        }

        for (int i = 1; i < size; i++) {

            if (visited[i - 1] == 0) {

                visited[i - 1] = 1;
                list.add(i);

                recursive(index + 1);

                visited[i - 1] = 0;
                list.remove(list.size() - 1);

            }

        }
        



    }



}