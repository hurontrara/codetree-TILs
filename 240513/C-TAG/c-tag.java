import java.io.*;
import java.util.*;


public class Main {

    static int n, m;

    static char[][] firstMatrix;
    static char[][] secondMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int answer = 0;

    static HashSet<String> hashSet = new HashSet<>();

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        firstMatrix = new char[n][m]; secondMatrix = new char[n][m];

        for (int i = 0; i < n; i++) {

            firstMatrix[i] = br.readLine().toCharArray();

        }

        for (int i = 0; i < n; i++) {

            secondMatrix[i] = br.readLine().toCharArray();

        }

        for (int i = 0; i < m; i++) {
            recursive(i, 0);
        }

        System.out.print(answer);



    }


    // m C 3
    static void recursive(int index, int count) {


        if (index == m && count == 3) {

            // set에 추가
            for (int i = 0; i < n; i++) {

                sb.setLength(0);

                for (int j = 0; j < 3; j++) {
                    sb.append(firstMatrix[i][list.get(j)]);
                }

                hashSet.add(sb.toString());

                

            }

            // 확인

            for (int i = 0; i < n; i++) {

                sb.setLength(0);

                for (int j = 0; j < 3; j++) {
                    sb.append(secondMatrix[i][list.get(j)]);
                }

                String string = sb.toString();

                if (hashSet.contains(string)) {
                    hashSet.clear();

                    return;
                }

            }

            answer += 1;

            hashSet.clear();

            return;
            


        }

        if (index == m || count == 3)
            return;
        

        list.add(index);
        for (int i = index; i < m; i++) {
            recursive(i + 1, count + 1);
        }
        list.remove(list.size() - 1);


    }


}