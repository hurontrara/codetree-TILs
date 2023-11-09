import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static int n = sc.nextInt();

    static String nString = sc.next();
    static String mString = sc.next();
    

    static List<Integer> changeList = new LinkedList<>();
    
    public static void main(String[] args) {

        int ans = 0;
        boolean mismatched = false;

        for(int i = 0; i < n; i++) {
            if(nString.charAt(i) != mString.charAt(i)) {
                // 다시 미스매치가 처음으로 발생하는 순간이라면
                // 답을 갱신해줍니다.
                if(!mismatched) {
                    mismatched = true;
                    ans++;
                }
            }
            else
                mismatched = false;
        }
        System.out.print(ans);


        }



    }