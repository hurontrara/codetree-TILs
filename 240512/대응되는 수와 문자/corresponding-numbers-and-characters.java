import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    static HashMap<String, Integer> stringToInt = new HashMap<>();
    static HashMap<Integer, String> intToString = new HashMap<>();

    public static void main(String[] args) throws Exception {

        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmArray = br.readLine().split(" "); n = Integer.parseInt(nmArray[0]); m = Integer.parseInt(nmArray[1]);

        for (int i = 1; i <= n; i++) {
            String string = br.readLine();
            stringToInt.put(string, i);
            intToString.put(i, string);
        }


        for (int i = 0; i < m; i++) {

            String input = br.readLine();

            try {
                 int intInput = Integer.parseInt(input);
                 System.out.println(intToString.get(intInput));
            } catch (Exception e) {

                System.out.println(stringToInt.get(input));

            }



        }



    }



}