import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" ");
        n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);

        recursive(1, 0);

    }

    static void recursive(int number, int index) {

        if (index == m) {

            // 출력
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();

            // 리턴
            return;

        }

        for (int i = number; i <= n; i++) {

            list.add(i);
            recursive(i + 1, index + 1);
            list.remove(list.size() - 1);

        }


    }



}