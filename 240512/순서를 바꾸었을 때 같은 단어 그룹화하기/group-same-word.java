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


        String[] inputArray;
        for (int i = 0; i < size; i++) {

            inputArray = br.readLine().split("");
            Arrays.sort(inputArray);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < inputArray.length; j++) {
                sb.append(inputArray[j]);
            }
            String string = sb.toString();

            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);

        }

        // logic + print
        for (int value : hashMap.values()) {
            answer = Math.max(answer, value);
        }

        System.out.print(answer);


    }


}