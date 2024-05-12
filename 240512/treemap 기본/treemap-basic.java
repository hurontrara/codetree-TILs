import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    static int n;


    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String[] array = br.readLine().split(" ");

            String order = array[0];

            if (order.equals("add")) {

                treeMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]));

            } else if (order.equals("find")) {

                int value = treeMap.getOrDefault(Integer.parseInt(array[1]), 0);

                System.out.println(value == 0 ? "None" : value);


            } else if (order.equals("remove")) {

                treeMap.remove(Integer.parseInt(array[1]));

            } else {

                if (!treeMap.isEmpty()) {

                    for (int value : treeMap.values()) {

                        System.out.print(value + " ");

                    }
                    System.out.println();

                } else {

                    System.out.println("None");


                }


            }



        }




    }



}