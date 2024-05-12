import java.io.*;
import java.util.stream.Stream;
import java.util.*;


public class Main {

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        // init

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] nArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] mArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        // logic
        for (int i = 0; i < nArray.length; i++) {

            int value = nArray[i];
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);

        }

        for (int i = 0; i < mArray.length; i++) {

            int value = mArray[i];
            System.out.print(hashMap.getOrDefault(value, 0) + " ");

        }


    }


}