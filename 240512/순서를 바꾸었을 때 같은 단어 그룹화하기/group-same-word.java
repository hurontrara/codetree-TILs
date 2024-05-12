import java.io.*;
import java.util.*;


public class Main {

    static int size;
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {

            String[] inputArray = br.readLine().split("");
            Arrays.sort(inputArray);
            String string = "";
            for (int j = 0; j < inputArray.length; j++) {
                string += inputArray[j];
            }

            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);

        }

        // logic + print
        for (int value : hashMap.values()) {
            answer = Math.max(answer, value);
        }

        System.out.print(answer);


    }


}