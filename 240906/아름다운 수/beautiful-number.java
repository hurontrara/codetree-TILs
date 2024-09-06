import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int idx = 0;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        
        n = Integer.parseInt(br.readLine());

        backTracking();

        System.out.print(cnt);

    }

    static void backTracking() {

        if (idx == n) {

            cnt++;

            return;

        }

        if (idx > n) {

            return;
        }

        for (int i = 1; i <= 4; i++) {

            idx += i;

            backTracking();

            idx -= i;

        }



    }



}

// 1자리 : 1개
// 2자리 : 2개 11, 22