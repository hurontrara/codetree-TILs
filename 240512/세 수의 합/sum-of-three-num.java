import java.io.*;
import java.util.stream.Stream;
import java.util.*;


public class Main {

    static int size, k;
    static int[] array;
    
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static int firstAnswer = 0;
    static int secondAnswer = 0;
    static int thridAnswer = 0;

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] skArray = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); size = skArray[0]; k = skArray[1];

        array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int value : array) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }


        // logic

        for (int firstKey : hashMap.keySet()) {

            for (int secondKey : hashMap.keySet()) {

                int thirdKey = k - firstKey - secondKey;

                if (!hashMap.containsKey(thirdKey)) {
                    continue;
                }

                int firstValue = hashMap.get(firstKey);
                int secondValue = hashMap.get(secondKey);
                int thirdValue = hashMap.get(thirdKey);


                if (firstKey == secondKey && secondKey == thirdKey) {
                    thridAnswer += firstValue * (firstValue - 1) * (firstValue - 2) / 6;
                    continue;
                }

                if (firstKey == secondKey) {
                    secondAnswer += firstValue * (firstValue - 1) * (thirdValue) / 2;
                } else if (secondKey == thirdKey) {
                    secondAnswer += firstValue * secondValue * (secondValue - 1) / 2;
                } else if (firstKey == thirdKey) {
                    secondAnswer += firstValue * (firstValue - 1) * secondValue / 2;
                } else {
                    firstAnswer += firstValue * secondValue * thirdValue;
                }

            }

        }


        // print
        System.out.print(firstAnswer / 6 + secondAnswer / 3 + thridAnswer);




    }
}