import java.io.*;
import java.util.*;

public class Main {

    static char[] array;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static HashSet<Character> hashSet = new HashSet<>();

    public static void main(String[] args) throws Exception {

        array = br.readLine().toCharArray();

        if (array.length == 1) {
            System.out.print(1);
            System.exit(0);
        }

        int left = 0;
        hashSet.add(array[0]);
        int answer = 0;
        for (int right = 1; right < array.length; right++) {

            while (hashSet.contains(array[right])) {
                hashSet.remove(array[left++]);
            }

            hashSet.add(array[right]);

            answer = Math.max(answer, right - left + 1);


        }
        System.out.print(answer);


    }


}