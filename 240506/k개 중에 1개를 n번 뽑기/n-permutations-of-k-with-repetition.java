import java.io.*;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static int n, k;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nkArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nkArray[0]; k = nkArray[1];

        recursive(0);

    }

    static void recursive(int index) {

        if (index == k) {
            for (int i = 0; i < k; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {

            list.add(i);
            recursive(index + 1);
            list.remove(list.size() - 1);

        }



    }


}