import java.io.*;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static int size;
    static int[][] matrix;

    static List<Integer> list = new ArrayList<>();

    static int[] visited;

    static int answer = 0;

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
        recursive(0);

        // 출력 
        System.out.print(answer);


    }

    static void recursive(int index) {

        // 합 구하는 로직
        if (index == size) {

            int cnt = 0;
            for (int i = 0; i < size; i++) {

                int row = i;
                int col = list.get(i);

                cnt += matrix[row][col];

            }

            answer = Math.max(cnt, answer);

            return;


        }

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