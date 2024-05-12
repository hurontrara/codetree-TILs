import java.io.*;
import java.util.*;


public class Main {

    static int size;

    static int count;

    static HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {

            String input = br.readLine();

            hashMap.put(input, hashMap.getOrDefault(input, 0) + 1);

            int localCount = hashMap.get(input);

            count = Math.max(count, localCount);

        }

        // print
        System.out.print(count);


    }




}