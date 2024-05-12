import java.io.*;
import java.util.*;



public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int size;
    static final HashMap<Integer, Integer> hashMap = new HashMap<>();
    static long answer = 0;

    public static void main(String[] args) throws Exception {
        
        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {

            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int x = array[0]; int y = array[1];

            if (hashMap.containsKey(x)) {

                int currentValue = hashMap.get(x);
                hashMap.put(x, Math.min(y, currentValue));

            } else {

                hashMap.put(x, y);

            }

        }


        for (int y : hashMap.values()) {

            answer += y;

        }
        System.out.print(answer);


    }

}