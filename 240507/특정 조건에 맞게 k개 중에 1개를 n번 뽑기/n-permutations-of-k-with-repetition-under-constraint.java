import java.io.*;
import java.util.*;


public class Main {

    static int n, k;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nkArray = br.readLine().split(" ");
        n = Integer.parseInt(nkArray[0]); k = Integer.parseInt(nkArray[1]);

        // 로직
        recursive(0);


    }


    static void recursive(int index) {

        if (index == k) {

            for (int i = 0; i < index; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            

            return;
        }


        for (int i = 1; i <= n; i++) {

            if (index >= 2 && list.get(index - 2) == list.get(index - 1) && list.get(index - 1) == i) 
                continue;
            
            list.add(i);
            recursive(index + 1);
            list.remove(list.size() - 1);



        }


    }
}