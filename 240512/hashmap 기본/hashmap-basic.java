import java.io.*;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static int size;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());


        // logic
        for (int i = 0; i < size; i++) {

            String[] stringArray = br.readLine().split(" ");    
            String order = stringArray[0]; int first = Integer.parseInt(stringArray[1]);

            if (order.equals("add")) {
                int second = Integer.parseInt(stringArray[2]);
                hashMap.put(first, second);
            } else if (order.equals("find")) {
                int value = hashMap.getOrDefault(first, 0);
                System.out.println(value != 0 ? value : "None");
            } else {
                hashMap.remove(first);
            }


        }



    }


}