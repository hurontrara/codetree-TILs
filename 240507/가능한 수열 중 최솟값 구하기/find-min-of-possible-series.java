import java.io.*;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static int size;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        // 로직
        recursive(0);





    }

    static boolean sameCheck(int firstPoint, int length) {

        
        for (int point = firstPoint; point < firstPoint + length; point++) {

            if (list.get(point) != list.get(point + length))
                return false;

        }

        return true;


    }


    static void recursive(int index) {


        // 불가능한 수열인지를 체크하는 부분
        // length : 길이 N 짜리 체크
        // 

        if (index == size) {

            for (int length = 1; length <= size / 2; length++) {

                for (int firstPoint = 0; firstPoint <= size - 2 * length; firstPoint++) {

                    if (sameCheck(firstPoint, length))
                        return;
                }


            }

            for (int i = 0; i < size; i++) {
                System.out.print(list.get(i));
            }
            System.exit(0);


            return;
        }


        for (int i = 4; i <= 6; i++) {
            list.add(i);
            recursive(index + 1);
            list.remove(list.size() - 1);
        }


    }


}