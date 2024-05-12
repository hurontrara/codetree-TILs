import java.io.*;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final HashMap<Character, Integer> hashMap = new HashMap<>();

    static List<Character> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // init
        char[] array = br.readLine().toCharArray();

        for (char key : array) {

            if (hashMap.containsKey(key)) {
                hashMap.put(key, 2);
                continue;
            }

            list.add(key);
            hashMap.put(key, 1);

        }
        

        // logic
        for (char key : list) {

            if (hashMap.get(key) == 1) {
                System.out.print(key);
                System.exit(0);
            }

        }
        System.out.print("None");


    }


}