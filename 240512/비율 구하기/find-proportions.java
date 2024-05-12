import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static TreeMap<String, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String input = br.readLine();

            treeMap.put(input, treeMap.getOrDefault(input, 0) + 1);


        }

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {

            System.out.printf(entry.getKey() + " " + "%.4f" + "\n", (float) entry.getValue() / n * 100);


        }


    }




}