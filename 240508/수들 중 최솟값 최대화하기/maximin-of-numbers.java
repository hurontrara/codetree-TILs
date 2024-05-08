import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static int size;
    static int[][] matrix;
    static int[] visited;

    static int answer = 0;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        matrix = new int[size][size];
        visited = new int[size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 로직
        // n = 3 ? 0 1 2 섞기
        // n = 4 ? 0 1 2 3 섞기
        recursive(0);

        // 출력
        System.out.print(answer);



    }

    static void recursive(int index) {

        // 계산
        // 한 케이스이므로 여기에서는 최솟값을 구하고
        // answer 에 대해서는 최대
        if (index == size) {

            int localMin = 10000;
            for (int i = 0; i < size; i++) {
                int row = i;
                int col = list.get(i);

                int value = matrix[row][col];

                localMin = Math.min(localMin, value);

            }

            answer = Math.max(answer, localMin);

            

        }

        // 섞기가 어렵기 때문에 이렇게 구현
        for (int i = 0; i < size; i++) {

            if (visited[i] == 0) {

                visited[i] = 1;
                list.add(i);

                recursive(index + 1);

                visited[i] = 0;
                list.remove(list.size() - 1);

            }

        }



    }




}