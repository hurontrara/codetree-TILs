import java.io.*;
import java.util.*;

public class Main {

    static char[] array;
    static int k;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static HashMap<Character, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        array = st.nextToken().toCharArray(); k = Integer.parseInt(st.nextToken());

        if (array.length == 1) {

            System.out.print(1);
            System.exit(0);

        }

        int left = 0;
        hashMap.put(array[0], 1);
        int answer = 0;
        for (int right = 1; right < array.length; right++) {

            // 1. 넣고 2. 확인 3. 만족할 때 까지 수정하면서 고고
            hashMap.put(array[right], hashMap.getOrDefault(array[right], 0) + 1);

            while (hashMap.size() > k) {

                int count = hashMap.get(array[left]);
                if (count == 1) {
                    hashMap.remove(array[left]);
                }
                else {
                    hashMap.put(array[left], count - 1);
                }

                left++;

            }

            answer = Math.max(answer, right - left + 1);

        }
        System.out.print(answer);



    }




}