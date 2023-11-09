import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            int num = sc.nextInt();

            treeMap.put(num, count);
        }

        greedy();


    }

    private static void greedy() {

        int maxValue = 0;
        while (treeMap.size() != 0) {

            Map.Entry<Integer, Integer> firstEntry = treeMap.firstEntry();
            Map.Entry<Integer, Integer> lastEntry = treeMap.lastEntry();

            maxValue = Math.max(maxValue, firstEntry.getKey() + lastEntry.getKey());

            if (firstEntry.getValue() == 1)
                treeMap.remove(firstEntry.getKey());
            else
                treeMap.put(firstEntry.getKey(), firstEntry.getValue() - 1);

            if (lastEntry.getValue() == 1)
                treeMap.remove(lastEntry.getKey());
            else
                treeMap.put(lastEntry.getKey(), lastEntry.getValue() - 1);

        }

        System.out.println(maxValue);


    }

}