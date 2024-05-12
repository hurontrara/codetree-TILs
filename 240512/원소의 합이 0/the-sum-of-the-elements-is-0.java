import java.io.*;
import java.util.stream.Stream;
import java.util.*;


public class Main {

    static int size;
    static int[] array;

    static int answer = 0;

    static List<HashMap<Integer, Integer>> hashMapList = new ArrayList<>();

    static HashMap<Integer, Integer> firstHashMap = new HashMap<>();
    static HashMap<Integer, Integer> secondHashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < 4; i++) {

            HashMap<Integer, Integer> localHashMap = new HashMap<>();

            array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < size; j++) {

                int value = array[j];
                localHashMap.put(value, localHashMap.getOrDefault(value, 0) + 1);

            }

            hashMapList.add(localHashMap);


        }

        // logic
        // 1. 두 해시맵 합쳐서 새로운 해시맵 -> 2개 생성

        for (int firstKey : hashMapList.get(0).keySet()) {
            for (int secondKey : hashMapList.get(1).keySet()) {

                int firstValue = hashMapList.get(0).get(firstKey);
                int secondValue = hashMapList.get(1).get(secondKey);

                firstHashMap.put(firstKey + secondKey, firstHashMap.getOrDefault(firstKey + secondKey, 0) + firstValue * secondValue);


            }
        }

        for (int firstKey : hashMapList.get(2).keySet()) {
            for (int secondKey : hashMapList.get(3).keySet()) {

                int firstValue = hashMapList.get(2).get(firstKey);
                int secondValue = hashMapList.get(3).get(secondKey);

                secondHashMap.put(firstKey + secondKey, secondHashMap.getOrDefault(firstKey + secondKey, 0) + firstValue * secondValue);


            }
        }


        // firstHashMap에 대하여 있으면 count에 더하기
        for (int firstKey : firstHashMap.keySet()) {

            int firstValue = firstHashMap.get(firstKey);

            int secondKey = -firstKey;

            int secondValue = secondHashMap.getOrDefault(secondKey, 0);

            answer += (firstValue * secondValue);

        }

        // print
        System.out.print(answer);





    }
}