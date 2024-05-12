import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m;

    static HashSet<Integer> hashSet1 = new HashSet<>();


    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        int[] firstArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int value : firstArray) {
            hashSet1.add(value);
        }

        m = Integer.parseInt(br.readLine());
        int[] secondArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 두번째 돌면서 첫번째에 있는 지 파악
        for (int value : secondArray) {
            System.out.print(hashSet1.contains(value) ? 1 : 0 + " ");
        }



    }



}