import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static String nString = sc.next();
    static String mString = sc.next();

    static String[] nStringList = nString.split("");
    static String[] mStringList = mString.split("");

    public static void main(String[] args) {

        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {

            if (!nStringList[i].equals(mStringList[i])) {
                press(i);
                cnt++;
            }
        }

        System.out.println(cnt);


    }

    private static void press(int index) {

        for (int i = 0; i <= index; i++) {

            if (nStringList[i].equals("G"))
                nStringList[i] = "H";
            else
                nStringList[i] = "G";

        }


    }


}