import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static int n = sc.nextInt();

    static String nString = sc.next();
    static String mString = sc.next();
    
    static String[] nStringArray = nString.split("");
    static String[] mStringArray = mString.split("");

    static List<Integer> changeList = new ArrayList<>();
    
    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {

            String nChar = nStringArray[i];
            String mChar = mStringArray[i];

            if (!nChar.equals(mChar))
                changeList.add(i);

        }

        for (int i = 0; i < changeList.size() - 1; i++) {

            Integer leftValue = changeList.get(i);
            Integer rightValue = changeList.get(i + 1);

            if (rightValue.equals(leftValue + 1))
                changeList.remove(leftValue);


        }

        System.out.println(changeList.size());


    }


    
    
}