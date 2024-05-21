import java.io.*;
import java.util.*;

public class Main {

    static long n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        n = Long.parseLong(br.readLine());
        hashMap.put(1, 0); 
        hashMap.put(2, 1); 
        hashMap.put(3, 3); 
        hashMap.put(4, 6); 
        hashMap.put(5, 7); 
        hashMap.put(6, 10); 
        hashMap.put(7, 12);
        hashMap.put(0, -2);


        long value = n / 8; long remain = n % 8;

        long answer = 0;
        answer += (value * 15) + 1; 
        answer += (long) hashMap.get((int) remain);

        System.out.print(answer);


    }


}