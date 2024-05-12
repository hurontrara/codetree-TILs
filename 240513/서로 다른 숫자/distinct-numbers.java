import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;

    static int[] array;

    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int value : array) {
            hashSet.add(value);
        }

        System.out.print(hashSet.size());

    }



}