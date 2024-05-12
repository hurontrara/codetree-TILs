import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int size;
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws Exception {
        
        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {

            String[] array = br.readLine().split(" ");
            String order = array[0]; int value = Integer.parseInt(array[1]);

            if (order.equals("find")) {
                System.out.println(hashSet.contains(value));
            } else if (order.equals("add")) {
                hashSet.add(value);
            } else {
                hashSet.remove(value);
            }



        }



    }



}