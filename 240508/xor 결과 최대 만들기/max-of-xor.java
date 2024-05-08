import java.io.*;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static int n, m;
    static int[] array;
    static List<Integer> list = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" ");
        n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);
        array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 로직
        recursive(0, 0);

        // 출력 
        System.out.print(answer);

    }


    static void recursive(int index, int count) {

        if (index == n && count == m) {

            // 출력 
            int firstValue = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                firstValue ^= list.get(i);
            }
            answer = Math.max(answer, firstValue);


            // 리턴

            return;
        }

        for (int i = index; i < n; i++) {

            list.add(array[i]);
            recursive(i + 1, count + 1);
            list.remove(list.size() - 1);


        }


    }


}