import java.io.*;
import java.util.*;

class Number {

    int number;
    int count;

    Number(int number, int count) { 
        this.number = number;
        this.count = count;
    }

}

public class Main {

    static int n;
    static int[] visited;

    static Queue<Number> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new int[3000001]; // "1이 인덱스 1에 담김"

        // logic
        queue.add(new Number(n, 0));
        visited[n] = 1;
        bfs();


    }


    static void bfs() {

        int futureValue;

        while (!queue.isEmpty()) {

            Number number = queue.poll();

            // 종료 조건
            if (number.number == 1) {
                System.out.print(number.count);
                System.exit(0);
            }

            if (number.number < 0) {
                continue;
            }

            // 1번 조건
            futureValue = number.number + 1;
            if (visited[futureValue] != 1) {
                visited[futureValue] = 1;
                queue.add(new Number(futureValue, number.count + 1));
            }

            // 2번 조건
            futureValue = number.number - 1;
            if (visited[futureValue] != 1) {
                visited[futureValue] = 1;
                queue.add(new Number(futureValue, number.count + 1));
            }

            // 3번
            futureValue = number.number / 2;
            if (number.number % 2 == 0 && visited[futureValue] != 1) {
                visited[futureValue] = 1;
                queue.add(new Number(futureValue, number.count + 1));
            }

            // 4번
            futureValue = number.number / 3;
            if (number.number % 3 == 0 && visited[futureValue] != 1) {
                visited[futureValue] = 1;
                queue.add(new Number(futureValue, number.count + 1));
            }




        }



    }


}