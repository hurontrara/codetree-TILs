import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Horse {

    int x;

    Horse(int x) {
        this.x = x;
    }

}


public class Main {

    static int turn, maxNum, horseNum;
    static int[] moveList;
    static List<Horse> horseList = new ArrayList<>();
    static List<Integer> moveHorseIndexList = new ArrayList<>();
    static int answer = 0;
    

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmArray = br.readLine().split(" ");
        turn = Integer.parseInt(tmArray[0]); maxNum = Integer.parseInt(tmArray[1]); horseNum = Integer.parseInt(tmArray[2]);

        moveList = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < horseNum; i++) {
            horseList.add(new Horse(1));
        }

        // 로직
        recursive(0);

        // 출력 
        System.out.print(answer);


    }


    static void recursive(int index) {

        // movehorseindexlist 꺼내서 각 말 움직이고 점수 카운트
        // horseList 초기화(1로)
        int count = 0;
        if (index == turn) {

            for (int i = 0; i < turn; i++) {

                int jump = moveList[i];
                Horse horse = horseList.get(moveHorseIndexList.get(i));

                if (horse.x >= maxNum)
                    continue;

                horse.x += jump;

                if (horse.x >= maxNum)
                    count += 1;

            }

            for (int i = 0; i < horseNum; i++) {
                Horse jumpedHorse = horseList.get(i);
                jumpedHorse.x = 1;
            }

            answer = Math.max(answer, count);

            
            return;
        }

        for (int i = 0; i < horseNum; i++) {
            moveHorseIndexList.add(i);
            recursive(index + 1);
            moveHorseIndexList.remove(moveHorseIndexList.size() - 1);
        }


    }
}