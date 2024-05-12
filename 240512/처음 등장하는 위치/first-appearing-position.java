import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] array;

    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        
        n = Integer.parseInt(br.readLine());
        array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= n; i++) {

            int value = array[i - 1];

            if (!treeMap.containsKey(value)) { 

                treeMap.put(value, i);

            }


        }

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {


            System.out.println(entry.getKey() + " " + entry.getValue());


        }



        

    }




}