import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;

    static List<HashSet<Integer>> list = new ArrayList<>();

    static Queue<Integer> queue = new LinkedList<>();

    static HashSet<Integer> answer = new HashSet<>();

    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int localSize = Integer.parseInt(st.nextToken());
            HashSet<Integer> localHashSet = new HashSet<>();

            for (int j = 0; j < localSize; j++) {

                localHashSet.add(Integer.parseInt(st.nextToken()));

            }

            list.add(localHashSet);


        }

        // 로직
        queue.add(1);

        queueingProcess();

        System.out.print(answer.size());





    }

    static void queueingProcess() {

        while (!queue.isEmpty()) {

            int value = queue.poll();
            answer.add(value);

            for (HashSet<Integer> hashSet : list) {

                if (hashSet.contains(value)) {
                    hashSet.remove(value);

                    if (hashSet.size() == 1) {

                        for (int localValue : hashSet) {
                            queue.add(localValue);

                        }

                    }

                }



            }


        }



    }



}


// 1번이 초대됨 -> List<HashMap<Integer>> 에 대하여 1번을 포함하는 지 파악 -> 1번 포함하면 1번 제거하면서 
// size 1 되는지 파악 -> size 1되면 큐에 넣어서 3번을 지움 -> 계속 반복

// hasMoreTokens