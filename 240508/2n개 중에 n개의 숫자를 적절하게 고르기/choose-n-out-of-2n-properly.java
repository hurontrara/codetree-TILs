import java.io.*;
import java.util.*;
import java.util.stream.Stream;



public class Main {

    static int n;
    static int[] array;
    static int allSum = 0;

    static int answer = Integer.MAX_VALUE;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < array.length; i++) {
            allSum += array[i];
        }

        // 로직
        for (int i = 0; i < 2 * n; i++) {
            recursive(i, 0);
        }

        // 출력
        System.out.print(answer);


    }

    static void recursive(int index, int count) {


        // 로직
        if (index == 2 * n && count == n) {

            int firstSum = 0;
            for (int i = 0; i < list.size(); i++) {
                firstSum += list.get(i);
            }

            int secondSum = allSum - firstSum;

            answer = Math.min(answer, Math.abs(secondSum - firstSum));

            return;
        }

        if (index == 2 * n || count == n) 
            return;

        list.add(array[index]);
        for (int i = index; i < 2 * n; i++) {
            recursive(i + 1, count + 1);
        }
        list.remove(list.size() - 1);



    }




}