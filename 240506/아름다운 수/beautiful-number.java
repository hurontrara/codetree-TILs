import java.io.*;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static int n;
    static int count = 0;

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 로직
        recursive(0);

        // 출력
        System.out.print(count);

    }

    static void recursive(int index) {

        if (index == n) {
            count++;
            return;
        }

        int space = n - index;
        for (int i = 1; i <= space; i++) {
            recursive(index + i);
        }


    }



}