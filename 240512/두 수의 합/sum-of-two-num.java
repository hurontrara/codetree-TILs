import java.io.*;
import java.util.*;
import java.util.stream.Stream;


public class Main {

    static int size, k;
    static int[] array;

    static int answer = 0;

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] skArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); size = skArray[0]; k = skArray[1];

        array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int value : array) {

            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);

        }

        // logic
        for (int key : hashMap.keySet()) {

            int counterKey = k - key;

            int value = hashMap.get(key);

            if (key == counterKey) {
                answer += (value * (value - 1));
                continue;
            }

            int counterValue = hashMap.getOrDefault(counterKey, 0);

            answer += (value * counterValue);

        }

        //print
        System.out.print(answer / 2);



    }




}