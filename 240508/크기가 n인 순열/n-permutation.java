import java.io.*;
import java.util.*;


public class Main {

    static int n;
    static List<Integer> list = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new int[n];

        // 로직
        recursive(0);




    }

    static void recursive(int index) {

        // 출력 로직
        if (index == n) {

            for (int i = 0; i < n; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();


            return;
        }


        for (int i = 1; i <= n; i++) {

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